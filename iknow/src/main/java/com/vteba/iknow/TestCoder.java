package com.vteba.iknow;


import java.util.HashMap;
import java.util.Map;

import org.mybatis.generator.GenMain;

import com.vteba.ext.codegen.CodeBuilder;
import com.vteba.ext.codegen.DB;
import com.vteba.ext.codegen.KeyType;
import com.vteba.ext.codegen.TempType;

public class TestCoder {

	public static void main(String[] args) {
		Map<String, String> tableListMap = new HashMap<String, String>();
		tableListMap.put("question_type", "问题分类信息");
		
	    //项目绝对路径
		String rootPath = "D:\\workspace\\iknow\\";
		CodeBuilder builder = new CodeBuilder(rootPath, TempType.Mybatis);
		builder.setConfigFilePath("src/main/resources/config.properties")
		.setSrcPath("src/main/java/")
		.schema("iknow")
		//.className("AppInfo")// 可以不设
		.setDb(DB.MySQL)// 可以不使用，只要jdbc url是正确的
		.keyType(KeyType.String)
		//.tableDesc("应用配置信息")
		//.tableName("app_info")
		.setTableList(tableListMap)
		.module("com.vteba.iknow.category")
		.setPojo(false)
		.setMongo(false)
		.setGenAction(false)
        .setGenDao(false)
        .setGenMapper(false)
        .setGenModel(false)
        .setGenService(false)
        .setMybatisShards(true)
		.build();

		GenMain.main(rootPath);
		
	}

}
