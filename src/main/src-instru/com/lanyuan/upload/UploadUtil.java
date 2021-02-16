// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.lanyuan.util.Common;

/**
 * 
 * 上传图片　工具类 大图片路径,生成小图片路径, 
 * 大图片文件名,生成小图片文名, 
 * 生成小图片宽度,生成小图片高度, 是否等比缩放(默认为true))
 * 
 * @author lanyuan
 * @Email：mmm333zzz520@163.com
 * @date：2014-12-05
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class UploadUtil
{
	private String imagePath = "/uploadFile/" + new SimpleDateFormat("yyyyMMddHH").format(new Date()) + "";// 配置图片路径

	/**
	 * 
	 * @param getUpload
	 *            路径
	 * @param getUploadContentType
	 *            文件类型
	 * @param getUploadFileName
	 *            原文件名
	 * @return
	 * @throws IOException
	 */
	public void uploadImage1(HttpServletRequest request,MultipartFile file, String getUploadContentType, String getUploadFileName) throws IOException
	{
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 191 0 8135540"); 

		String getImagePath = request.getSession().getServletContext().getRealPath(imagePath);

		File image = new File(getImagePath);
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 191 1 8135540")|| true) && (!image.exists()? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 191 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 191 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 191 2 8135540");
		{
			image.mkdir();
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 191 3 8135540");

		// 得到文件的新名字
		String fileNewName = Common.generateFileName(getUploadFileName);

		// 最后返回图片路径
		imagePath = imagePath + "/" + fileNewName;

		BufferedImage srcBufferImage = ImageIO.read(file.getInputStream());
		BufferedImage scaledImage;
		ScaleImage scaleImage = ScaleImage.getInstance();
		int yw = srcBufferImage.getWidth();
		int yh = srcBufferImage.getHeight();
		int w = 400, h = 300;
		// 如果上传图片 宽高 比 压缩的要小 则不压缩
		int zoa_cond_n4_0 = 2;
int zoa_cond_n4_1 = 2;
//zoa_cond_n4_0#w > yw$zoa_cond_n4_1#h > yh
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 191 4 8135540")|| true) && ((w > yw?(zoa_cond_n4_0 != (zoa_cond_n4_0 = 1)):(zoa_cond_n4_0 == (zoa_cond_n4_0 = 0))) && (h > yh?(zoa_cond_n4_1 != (zoa_cond_n4_1 = 1)):(zoa_cond_n4_1 == (zoa_cond_n4_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 191 3 1 1 2 ","8135540",true,zoa_cond_n4_0,zoa_cond_n4_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 191 3 1 0 2 ","8135540",false,zoa_cond_n4_0,zoa_cond_n4_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 191 5 8135540");
		{
			FileOutputStream fos = new FileOutputStream(getImagePath + "/" + fileNewName);

			FileInputStream fis = (FileInputStream) file.getInputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 191 6 8135540")|| true) && ((len = fis.read(buffer)) > 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 191 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 191 4 2 0 0 ","8135540",false,0) && false))){ ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 191 7 8135540"); 
			{
				fos.write(buffer, 0, len);
			}}
		} }
		else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 191 9 8135540"); 
		{
			scaledImage = scaleImage.imageZoomOut(srcBufferImage, w, h);
			FileOutputStream out = new FileOutputStream(getImagePath + "/" + fileNewName);
			ImageIO.write(scaledImage, "jpeg", out);

		} }
	}


	public String getImagepath()
	{
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 191 11 8135540"); 
		return imagePath;
	}

}