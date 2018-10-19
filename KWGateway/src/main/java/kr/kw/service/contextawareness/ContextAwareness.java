package kr.kw.service.contextawareness;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import kr.kw.util.KWLOG;
import kr.kw.util.KWUtils;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * [for Linux]
 * 
 * You must install libatlas3-base, libopenblas-base and libgfortran3 to solve below warning.
 * 
 * WARNING: Failed to load implementation from: com.github.fommil.netlib.NativeSystemARPACK
 * 
 * 	# apt-get install libatlas3-base libopenblas-base
 * 
 * 	OR
 * 
 * 	<dependency>
 *		<groupId>com.github.fommil.netlib</groupId>
 *		<artifactId>all</artifactId>
 *		<version>1.1.2</version>
 *		<type>pom</type>
 *	</dependency>
 * 
 * WARNING: Failed to load implementation from: com.github.fommil.netlib.NativeRefARPACK
 * 
 * 	# apt-get install libgfortran3
 * 
 * */
public class ContextAwareness {
	private static final String TAG = "ContextAwareness";
	
	private Map<String, Instances> wekaData;
	private Map<String, PrintWriter> wekaFiles;
	
	public ContextAwareness() {
		wekaData = new HashMap<String, Instances>();
		wekaFiles = new HashMap<String, PrintWriter>();
	}

	/*private void setWekaInstancesFromDB() {
		if(isInit) {
			KWLOG.debug(TAG, "instances were already initialized");
		}
		
		try {
			InstanceQuery query = new InstanceQuery();
			query.setDatabaseURL("jdbc:mysql://localhost:3306/smarthome5th");
			query.setUsername("root");
			query.setPassword("odroid");
			query.setQuery("SELECT "
					+ "gw.gatewayId, "
					+ "ha.homeapplianceId, ha.homeapplianceName, ha.homeapplianceType, ha.homeapplianceFunction, ha.homeapplianceManufacturer, "
					+ "ss.sensorId, ss.sensorName, ss.sensorType, ss.sensorStatus, ss.sensorManufacturer "
					+ "FROM gateway AS gw, homeappliance AS ha, sensor AS ss "
					+ "WHERE gw.gatewayId = ha.gatewayId AND gw.gatewayID = ss.gatewayId;");
			wekaData = query.retrieveInstances();
			
			KWLOG.debug(TAG, wekaData.toSummaryString());
			if(wekaData != null) {
				isInit = true;
				KWLOG.debug(TAG, "success to set instances from database");
			}
			query.disconnectFromDatabase();
			query.close();
		} catch (Exception e) {
			KWLOG.excep(TAG, e.getMessage());
		}
	}*/
	
	public String setWekaInstanceFromARFF(final String fileName) {
		if(!new File(fileName).isFile()) {
			return null;
		}
		
		try {
			if(!wekaData.containsKey(fileName)) {
				DataSource source = new DataSource(fileName);
				Instances wekaInstances = source.getDataSet();
				// setting class attribute if the data format does not provide this information
				// For example, the XRFF format saves the class attribute information as well
				if (wekaInstances.classIndex() == -1)
					wekaInstances.setClassIndex(wekaInstances.numAttributes() - 1);

				wekaData.put(fileName, wekaInstances);
				
				PrintWriter wekaFile = getFile(fileName);
				if(wekaFile != null) {
					wekaFiles.put(fileName, wekaFile);	
					appendData(fileName, "\n\n%open " + KWUtils.getDateTime() + "\n");
				}	
				
				KWLOG.info(TAG, "success to set weka instance: " + fileName);
				
				return wekaInstances.relationName();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public Evaluation wekaModel(String fileName) {
		Evaluation eval = null;
		Instances wekaInstaces = wekaData.get(fileName);
		try {
			// train classifier
			Classifier cls = new J48();
			cls.buildClassifier(wekaInstaces);

			// evaluate classifier and print some statistics
			eval = new Evaluation(wekaInstaces);
			eval.evaluateModel(cls, wekaInstaces);
			KWLOG.info(TAG, eval.toSummaryString("\nResults\n======\n", false));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return eval;
	}
	
	public double wekaClassify(String fileName, double[] instanceValue) {
		KWLOG.info(TAG, "classify : " + fileName);
		
		double predict = -1;
		Instances wekaInstance = wekaData.get(fileName);
		
		try {
			Classifier cls = new J48();
			cls.buildClassifier(wekaInstance);
			DenseInstance d = new DenseInstance(1.0, instanceValue);
			d.replaceMissingValues(instanceValue);
			wekaInstance.add(d);
			wekaInstance.setClassIndex(wekaInstance.numAttributes()-1);
		
			Instance result = wekaInstance.lastInstance();
			predict = cls.classifyInstance(result);
			result.setClassValue(predict);
//			System.out.println("result: " + wekaInstance.toString());
//			System.out.println("result: " + wekaInstance.classAttribute().value((int) predict));
			KWLOG.info(TAG, "result: " + wekaInstance.classAttribute().value((int) predict));

			appendData(fileName, result.toString() + "\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return predict;
	}
	
	private PrintWriter getFile(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			return new PrintWriter(bw);
		} catch (IOException e) {
			KWLOG.excep(TAG, e.getMessage());
		}
		
		return null;
	}
	
	private void appendData(String fileName, String data) {
		PrintWriter wekaFile = wekaFiles.get(fileName);
		wekaFile.append(data);
		wekaFile.flush();
	}
	
	public void finish() {
		for(PrintWriter wekaFile : wekaFiles.values()) {
			wekaFile.close();
		}
	}
	
//	public String getWekaClass(int index) {
//		return wekaData.classAttribute().value(index);
//	}
}
