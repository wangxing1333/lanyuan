// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class DownloadUtils {
	private static Logger logger = LoggerFactory.getLogger(DownloadUtils.class);
	public static void download(String fileName,String filepath, HttpServletRequest request, HttpServletResponse response)
				throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 202 0 8135540"); 
	
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			java.io.BufferedInputStream bis = null;
			java.io.BufferedOutputStream bos = null;
	
			String ctxPath = request.getSession().getServletContext().getRealPath("/") +filepath;
			try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 1 8135540"); 
				File file = new File(ctxPath);
				if((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 2 8135540")|| true) && (!file.exists()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 202 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 202 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 3 8135540");
					logger.warn("download agent is error ! messages --->> "+ctxPath+" is not exists !"); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 4 8135540");
				response.setContentType("application/x-msdownload;");
				response.setHeader("Content-disposition",
						"attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
				response.setHeader("Content-Length", String.valueOf(file.length()));
				bis = new BufferedInputStream(new FileInputStream(ctxPath));
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 5 8135540")|| true) && (-1 != (bytesRead = bis.read(buff, 0, buff.length))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 202 1 1 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 202 1 1 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 6 8135540");  {
					bos.write(buff, 0, bytesRead);
				}}
			} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 8 8135540"); 
				logger.warn("download agent is error ! messages --->> "+e.fillInStackTrace());
			} finally {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 9 8135540"); 
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 10 8135540")|| true) && (bis != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 202 2 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 202 2 2 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 11 8135540");
					bis.close(); }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 12 8135540");
				if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 13 8135540")|| true) && (bos != null? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 202 3 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 202 3 3 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 202 14 8135540");
					bos.close(); }
			}
		}
}

