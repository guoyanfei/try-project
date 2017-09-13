package com.guo.code.testtool;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gyf .
 * 2017/4/1 .
 */
public class CsvParser {

    public static class App {

        private Long   id;
        private Long   developerId;
        private String developerAcount;
        private String appName;
        private String os;
        private String pid;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getDeveloperId() {
            return developerId;
        }

        public void setDeveloperId(Long developerId) {
            this.developerId = developerId;
        }

        public String getDeveloperAcount() {
            return developerAcount;
        }

        public void setDeveloperAcount(String developerAcount) {
            this.developerAcount = developerAcount;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }
    }

    // Saved input CSV file pathname
    private String inputCsvFile;

    // Space mark , ; : etc.
    private String spaceMark = ",";

    /**
     * Contructor
     *
     * @param inputCsvFile
     */
    public CsvParser(String inputCsvFile, String spaceMark) {
        this.inputCsvFile = inputCsvFile;
        this.spaceMark = spaceMark;
    }

    /**
     * Contructor
     *
     * @param inputCsvFile
     */
    public CsvParser(String inputCsvFile) {
        this.inputCsvFile = inputCsvFile;
        this.spaceMark = ",";
    }

    /**
     * Get parsed array from CSV file
     *
     * @return
     */
    public List<App> getParsedArray() throws Exception {
        List<App> retval = new ArrayList<App>();

        BufferedReader in = new BufferedReader(new FileReader(this.inputCsvFile));
        String strLine;
        String str = "";

        in.readLine();
        while ((strLine = in.readLine()) != null) {

            String[] line = strLine.split(",");
            Map<String, Map<String, String>> appContentMap;
            try {
                //System.out.println(strLine.substring(strLine.indexOf(",\"{\"") + 2, strLine.length()-1));
                appContentMap = JSONObject.parseObject(strLine.substring(strLine.indexOf(",\"{\"") + 2, strLine.length()-1), new TypeReference<Map<String, Map<String, String>>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
                appContentMap = new HashMap<>();
            }
            for (Map.Entry<String, Map<String, String>> it : appContentMap.entrySet()) {
                App app = new App();
                app.setId(Long.valueOf(line[0]));
                app.setDeveloperId(Long.valueOf(line[1]));
                app.setDeveloperAcount(line[2]);
                app.setAppName(line[3]);
                app.setOs(it.getKey());
                app.setPid(it.getValue().get("pid"));
                retval.add(app);
            }
        }
        in.close();

        return retval;
    }

    /**
     * Test
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CsvParser parser = new CsvParser("/Users/gyf/Downloads/temp/shanghuadata.csv");
        List<App> arr = parser.getParsedArray();

        for (App it : arr) {
            String str = String.format(",(%s,%s,'%s','%s','%s','%s')", it.getId(), it.getDeveloperId(), it.getDeveloperAcount(), it.getAppName(), it.getOs(), StringUtils.isNotBlank(it.getPid())?it.getPid():"");
            System.out.println(str);
        }
    }
}
