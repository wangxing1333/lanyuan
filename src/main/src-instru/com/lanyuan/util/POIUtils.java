// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 读写EXCEL文件
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class POIUtils {

	/**
	 * @author lijianning
	 * Email：mmm333zzz520@163.com
	 * date：2015-11-11
	 * @param exportData 列表头
	 * @param lis 数据集
	 * @param fileName 文件名
	 * 
	 */
	public static void exportToExcel(HttpServletResponse response, List<Map<String, Object>> exportData, List<?> lis,
			String fileName) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 172 0 8135540"); 
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 1 8135540"); 
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ExcelUtil.createWorkBook(exportData, lis).write(os);
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			// 设置response参数，可以打开下载页面
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
			ServletOutputStream out = response.getOutputStream();
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 2 8135540")|| true) && (-1 != (bytesRead = bis.read(buff, 0, buff.length))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 172 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 172 0 0 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 3 8135540");  {
				bos.write(buff, 0, bytesRead);
			}}
		} catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 5 8135540"); 
			e.printStackTrace();
		} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 6 8135540"); 
				try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 7 8135540"); 
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 8 8135540")|| true) && (bis != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 172 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 172 1 1 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 9 8135540");
					bis.close(); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 10 8135540");
					if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 11 8135540")|| true) && (bos != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 172 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 172 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 12 8135540");
						bos.close(); }
				} catch (IOException e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 172 14 8135540"); 
				}
			
		}
	}

}