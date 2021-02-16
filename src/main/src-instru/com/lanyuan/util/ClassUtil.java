// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ClassUtil {

	public static void main(String[] args) throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 251 0 8135540"); 
		String packageName = "com.lanyuan.entity";
		// List<String> classNames = getClassName(packageName);
		List<String> classNames = getClassName(packageName, false);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 1 8135540")|| true) && (classNames != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 2 8135540"); {
			for (String className : /* TRUE */classNames){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 3 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 4 8135540"); {
				System.out.println(className);
			}}
		} }
	}

	/**
	 * 获取某包下（包括该包的所有子包）所有类
	 * @param packageName 包名
	 * @return 类的完整名称
	 */
	public static List<String> getClassName(String packageName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 251 7 8135540"); 
		return getClassName(packageName, true);
	}

	/**
	 * 获取某包下所有类
	 * @param packageName 包名
	 * @param childPackage 是否遍历子包
	 * @return 类的完整名称
	 */
	public static List<String> getClassName(String packageName, boolean childPackage) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 251 8 8135540"); 
		List<String> fileNames = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String packagePath = packageName.replace(".", "/");
		URL url = loader.getResource(packagePath);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 9 8135540")|| true) && (url != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 10 8135540"); {
			String type = url.getProtocol();
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 11 8135540")|| true) && (type.equals("file")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 12 8135540"); {
				fileNames = getClassNameByFile(url.getPath(), null, childPackage);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 13 8135540");  if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 14 8135540")|| true) && (type.equals("jar")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 15 8135540"); {
				fileNames = getClassNameByJar(url.getPath(), childPackage);
			} } }
		} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 18 8135540");  {
			fileNames = getClassNameByJars(((URLClassLoader) loader).getURLs(), packagePath, childPackage);
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 19 8135540");
		return fileNames;
	}

	/**
	 * 从项目文件获取某包下所有类
	 * @param filePath 文件路径
	 * @param className 类名集合
	 * @param childPackage 是否遍历子包
	 * @return 类的完整名称
	 */
	private static List<String> getClassNameByFile(String filePath, List<String> className, boolean childPackage) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 251 20 8135540"); 
		List<String> myClassName = new ArrayList<String>();
		File file = new File(filePath);
		File[] childFiles = file.listFiles();
		for (File childFile : /* TRUE */childFiles){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 21 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 22 8135540"); {
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 23 8135540")|| true) && (childFile.isDirectory()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 4 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 4 4 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 24 8135540"); {
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 25 8135540")|| true) && (childPackage? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 5 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 5 5 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 26 8135540"); {
					myClassName.addAll(getClassNameByFile(childFile.getPath(), myClassName, childPackage));
				} }
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 28 8135540");  {
				String childFilePath = childFile.getPath();
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 29 8135540")|| true) && (childFilePath.endsWith(".class")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 6 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 6 6 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 30 8135540"); {
					childFilePath=childFilePath.replaceAll("/","\\\\");
					childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
					childFilePath = childFilePath.replace("\\", ".");
					myClassName.add(childFilePath);
				} }
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 33 8135540");

		return myClassName;
	}

	/**
	 * 从jar获取某包下所有类
	 * @param jarPath jar文件路径
	 * @param childPackage 是否遍历子包
	 * @return 类的完整名称
	 */
	private static List<String> getClassNameByJar(String jarPath, boolean childPackage) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 251 34 8135540"); 
		List<String> myClassName = new ArrayList<String>();
		String[] jarInfo = jarPath.split("!");
		String jarFilePath = jarInfo[0].substring(jarInfo[0].indexOf("/"));
		String packagePath = jarInfo[1].substring(1);
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 35 8135540"); 
			JarFile jarFile = new JarFile(jarFilePath);
			Enumeration<JarEntry> entrys = jarFile.entries();
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 36 8135540")|| true) && (entrys.hasMoreElements()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 7 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 7 7 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 37 8135540");  {
				JarEntry jarEntry = entrys.nextElement();
				String entryName = jarEntry.getName();
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 38 8135540")|| true) && (entryName.endsWith(".class")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 8 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 8 8 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 39 8135540"); {
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 40 8135540")|| true) && (childPackage? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 9 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 9 9 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 41 8135540"); {
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 42 8135540")|| true) && (entryName.startsWith(packagePath)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 10 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 10 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 43 8135540"); {
							entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
							myClassName.add(entryName);
						} }
					} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 45 8135540");  {
						int index = entryName.lastIndexOf("/");
						String myPackagePath;
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 46 8135540")|| true) && (index != -1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 11 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 11 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 47 8135540"); {
							myPackagePath = entryName.substring(0, index);
						} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 48 8135540");  {
							myPackagePath = entryName;
						} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 49 8135540");
						if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 50 8135540")|| true) && (myPackagePath.equals(packagePath)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 12 12 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 12 12 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 51 8135540"); {
							entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
							myClassName.add(entryName);
						} }
					} }
				} }
			}}
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 56 8135540"); 
			e.printStackTrace();
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 57 8135540");
		return myClassName;
	}

	/**
	 * 从所有jar中搜索该包，并获取该包下所有类
	 * @param urls URL集合
	 * @param packagePath 包路径
	 * @param childPackage 是否遍历子包
	 * @return 类的完整名称
	 */
	private static List<String> getClassNameByJars(URL[] urls, String packagePath, boolean childPackage) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 251 58 8135540"); 
		List<String> myClassName = new ArrayList<String>();
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 59 8135540")|| true) && (urls != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 13 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 13 13 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 60 8135540"); {
			for (int i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 61 8135540")|| true) && (i < urls.length? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 14 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 14 14 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 62 8135540"); {
				URL url = urls[i];
				String urlPath = url.getPath();
				// 不必搜索classes文件夹
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 63 8135540")|| true) && (urlPath.endsWith("classes/")? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 15 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 251 15 15 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 64 8135540"); {
					continue;
				} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 65 8135540");
				String jarPath = urlPath + "!/" + packagePath;
				myClassName.addAll(getClassNameByJar(jarPath, childPackage));
			}}
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 251 67 8135540");
		return myClassName;
	}
}