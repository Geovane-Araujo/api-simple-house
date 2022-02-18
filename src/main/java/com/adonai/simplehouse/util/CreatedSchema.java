package com.adonai.simplehouse.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class CreatedSchema {

    private final static Logger LOGGER = LoggerFactory.getLogger(CreatedSchema.class.getName());

    public static String executeSql(String schemaName, String fileName){

        String sql = "";
        try{
            File file = ResourceUtils.getFile("classpath:db/db_creation/"+fileName);
            FileInputStream in = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(reader);

            String linha = br.readLine();
            while (linha != null){
                sql += linha;
                linha = br.readLine();
            }

        } catch (IOException ex){
            LOGGER .error(ex.getMessage());
        }

        return sql.replace("@@schema_name",schemaName);
    }

    public void createdSchema(String schemaName){

    }

}
