// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.upload;


import java.awt.image.BufferedImage;
/** 
* @author lanyuan
* @Email：mmm333zzz520@163.com
* @date：2014-12-05
*/
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ScaleImage {
	private int width;

	private int height;

	private int scaleWidth;

	private double support = (double) 3.0;

	private double PI = (double) 3.14159265358978;

	private double[] contrib;

	private double[] normContrib;

	private double[] tmpContrib;

	private int nDots;

	private int nHalfDots;

	/**
	 * Start: Use Lanczos filter to replace the original algorithm for image
	 * scaling. Lanczos improves quality of the scaled image modify by :blade
	 */
	private static ScaleImage instance = new ScaleImage();
	private ScaleImage(){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 0 8135540"); };
	public static ScaleImage getInstance(){
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 1 8135540"); 
		return instance;
	}
	public BufferedImage imageZoomOut(BufferedImage srcBufferImage, int w, int h) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 2 8135540"); 
		width = srcBufferImage.getWidth();
		height = srcBufferImage.getHeight();
		scaleWidth = w;

		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 3 8135540")|| true) && (DetermineResultSize(w, h) == 1? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 0 0 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 0 0 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 4 8135540"); {
			return srcBufferImage;
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 5 8135540");
		CalContrib();
		BufferedImage pbOut = HorizontalFiltering(srcBufferImage, w);
		BufferedImage pbFinalOut = VerticalFiltering(pbOut, h);
		return pbFinalOut;
	}

	/**
	 * 决定图像尺寸
	 */
	private int DetermineResultSize(int w, int h) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 6 8135540"); 
		double scaleH, scaleV;
		scaleH = (double) w / (double) width;
		scaleV = (double) h / (double) height;
		// �?��判断�?��scaleH，scaleV，不做放大操�?
		int zoa_cond_n7_0 = 2;
int zoa_cond_n7_1 = 2;
//zoa_cond_n7_0#scaleH >= 1.0$zoa_cond_n7_1#scaleV >= 1.0
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 7 8135540")|| true) && ((scaleH >= 1.0?(zoa_cond_n7_0 != (zoa_cond_n7_0 = 1)):(zoa_cond_n7_0 == (zoa_cond_n7_0 = 0))) && (scaleV >= 1.0?(zoa_cond_n7_1 != (zoa_cond_n7_1 = 1)):(zoa_cond_n7_1 == (zoa_cond_n7_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 3 1 1 2 ","8135540",true,zoa_cond_n7_0,zoa_cond_n7_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 3 1 0 2 ","8135540",false,zoa_cond_n7_0,zoa_cond_n7_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 8 8135540"); {
			return 1;
		} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 9 8135540");
		return 0;

	} // end of DetermineResultSize()

	private double Lanczos(int i, int inWidth, int outWidth, double Support) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 10 8135540"); 
		double x;

		x = (double) i * (double) outWidth / (double) inWidth;

		return Math.sin(x * PI) / (x * PI) * Math.sin(x * PI / Support)
				/ (x * PI / Support);

	} // end of Lanczos()

	//  
	// Assumption: same horizontal and vertical scaling factor
	//  
	private void CalContrib() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 11 8135540"); 
		nHalfDots = (int) ((double) width * support / (double) scaleWidth);
		nDots = nHalfDots * 2 + 1;
		try {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 12 8135540"); 
			contrib = new double[nDots];
			normContrib = new double[nDots];
			tmpContrib = new double[nDots];
		} catch (Exception e) {ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 13 8135540"); 
		}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 14 8135540");

		int center = nHalfDots;
		contrib[center] = 1.0;

		double weight = 0.0;
		int i = 0;
		for (i = 1; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 15 8135540")|| true) && (i <= center? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 4 2 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 4 2 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 16 8135540"); {
			contrib[center + i] = Lanczos(i, width, scaleWidth, support);
			weight += contrib[center + i];
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 17 8135540");

		for (i = center - 1; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 18 8135540")|| true) && (i >= 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 5 3 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 5 3 0 0 ","8135540",false,0) && false)); i--){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 19 8135540"); {
			contrib[i] = contrib[center * 2 - i];
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 20 8135540");

		weight = weight * 2 + 1.0;

		for (i = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 21 8135540")|| true) && (i <= center? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 6 4 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 6 4 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 22 8135540"); {
			normContrib[i] = contrib[i] / weight;
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 23 8135540");

		for (i = center + 1; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 24 8135540")|| true) && (i < nDots? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 7 5 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 7 5 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 25 8135540"); {
			normContrib[i] = normContrib[center * 2 - i];
		}}
	} // end of CalContrib()

	// 处理边缘
	private void CalTempContrib(int start, int stop) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 27 8135540"); 
		double weight = 0;

		int i = 0;
		for (i = start; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 28 8135540")|| true) && (i <= stop? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 8 6 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 8 6 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 29 8135540"); {
			weight += contrib[i];
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 30 8135540");

		for (i = start; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 31 8135540")|| true) && (i <= stop? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 9 7 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 9 7 0 0 ","8135540",false,0) && false)); i++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 32 8135540"); {
			tmpContrib[i] = contrib[i] / weight;
		}}

	} // end of CalTempContrib()

	private int GetRedValue(int rgbValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 34 8135540"); 
		int temp = rgbValue & 0x00ff0000;
		return temp >> 16;
	}

	private int GetGreenValue(int rgbValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 35 8135540"); 
		int temp = rgbValue & 0x0000ff00;
		return temp >> 8;
	}

	private int GetBlueValue(int rgbValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 36 8135540"); 
		return rgbValue & 0x000000ff;
	}

	private int ComRGB(int redValue, int greenValue, int blueValue) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 37 8135540"); 

		return (redValue << 16) + (greenValue << 8) + blueValue;
	}

	// 行水平滤�?
	private int HorizontalFilter(BufferedImage bufImg, int startX, int stopX,
			int start, int stop, int y, double[] pContrib) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 38 8135540"); 
		double valueRed = 0.0;
		double valueGreen = 0.0;
		double valueBlue = 0.0;
		int valueRGB = 0;
		int i, j;

		for (i = startX, j = start; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 39 8135540")|| true) && (i <= stopX? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 10 8 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 10 8 0 0 ","8135540",false,0) && false)); i++, j++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 40 8135540"); {
			valueRGB = bufImg.getRGB(i, y);

			valueRed += GetRedValue(valueRGB) * pContrib[j];
			valueGreen += GetGreenValue(valueRGB) * pContrib[j];
			valueBlue += GetBlueValue(valueRGB) * pContrib[j];
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 41 8135540");

		valueRGB = ComRGB(Clip((int) valueRed), Clip((int) valueGreen),
				Clip((int) valueBlue));
		return valueRGB;

	} // end of HorizontalFilter()

	// 图片水平滤波
	private BufferedImage HorizontalFiltering(BufferedImage bufImage, int iOutW) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 42 8135540"); 
		int dwInW = bufImage.getWidth();
		int dwInH = bufImage.getHeight();
		int value = 0;
		BufferedImage pbOut = new BufferedImage(iOutW, dwInH,
				BufferedImage.TYPE_INT_RGB);

		for (int x = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 43 8135540")|| true) && (x < iOutW? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 11 9 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 11 9 0 0 ","8135540",false,0) && false)); x++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 44 8135540"); {

			int startX;
			int start;
			int X = (int) (((double) x) * ((double) dwInW) / ((double) iOutW) + 0.5);
			int y = 0;

			startX = X - nHalfDots;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 45 8135540")|| true) && (startX < 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 12 10 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 12 10 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 46 8135540"); {
				startX = 0;
				start = nHalfDots - X;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 47 8135540");  {
				start = 0;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 48 8135540");

			int stop;
			int stopX = X + nHalfDots;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 49 8135540")|| true) && (stopX > (dwInW - 1)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 13 11 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 13 11 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 50 8135540"); {
				stopX = dwInW - 1;
				stop = nHalfDots + (dwInW - 1 - X);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 51 8135540");  {
				stop = nHalfDots * 2;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 52 8135540");

			int zoa_cond_n53_0 = 2;
int zoa_cond_n53_1 = 2;
//zoa_cond_n53_0#start > 0$zoa_cond_n53_1#stop < nDots - 1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 53 8135540")|| true) && ((start > 0?(zoa_cond_n53_0 != (zoa_cond_n53_0 = 1)):(zoa_cond_n53_0 == (zoa_cond_n53_0 = 0))) || (stop < nDots - 1?(zoa_cond_n53_1 != (zoa_cond_n53_1 = 1)):(zoa_cond_n53_1 == (zoa_cond_n53_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 16 12 1 2 ","8135540",true,zoa_cond_n53_0,zoa_cond_n53_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 16 12 0 2 ","8135540",false,zoa_cond_n53_0,zoa_cond_n53_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 54 8135540"); {
				CalTempContrib(start, stop);
				for (y = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 55 8135540")|| true) && (y < dwInH? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 17 13 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 17 13 0 0 ","8135540",false,0) && false)); y++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 56 8135540"); {
					value = HorizontalFilter(bufImage, startX, stopX, start,
							stop, y, tmpContrib);
					pbOut.setRGB(x, y, value);
				}}
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 58 8135540");  {
				for (y = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 59 8135540")|| true) && (y < dwInH? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 18 14 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 18 14 0 0 ","8135540",false,0) && false)); y++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 60 8135540"); {
					value = HorizontalFilter(bufImage, startX, stopX, start,
							stop, y, normContrib);
					pbOut.setRGB(x, y, value);
				}}
			} }
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 63 8135540");

		return pbOut;

	} // end of HorizontalFiltering()

	private int VerticalFilter(BufferedImage pbInImage, int startY, int stopY,
			int start, int stop, int x, double[] pContrib) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 64 8135540"); 
		double valueRed = 0.0;
		double valueGreen = 0.0;
		double valueBlue = 0.0;
		int valueRGB = 0;
		int i, j;

		for (i = startY, j = start; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 65 8135540")|| true) && (i <= stopY? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 19 15 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 19 15 0 0 ","8135540",false,0) && false)); i++, j++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 66 8135540"); {
			valueRGB = pbInImage.getRGB(x, i);

			valueRed += GetRedValue(valueRGB) * pContrib[j];
			valueGreen += GetGreenValue(valueRGB) * pContrib[j];
			valueBlue += GetBlueValue(valueRGB) * pContrib[j];
		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 67 8135540");

		valueRGB = ComRGB(Clip((int) valueRed), Clip((int) valueGreen),
				Clip((int) valueBlue));
		return valueRGB;

	} // end of VerticalFilter()

	private BufferedImage VerticalFiltering(BufferedImage pbImage, int iOutH) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 68 8135540"); 
		int iW = pbImage.getWidth();
		int iH = pbImage.getHeight();
		int value = 0;
		BufferedImage pbOut = new BufferedImage(iW, iOutH,
				BufferedImage.TYPE_INT_RGB);

		for (int y = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 69 8135540")|| true) && (y < iOutH? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 20 16 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 20 16 0 0 ","8135540",false,0) && false)); y++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 70 8135540"); {

			int startY;
			int start;
			int Y = (int) (((double) y) * ((double) iH) / ((double) iOutH) + 0.5);

			startY = Y - nHalfDots;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 71 8135540")|| true) && (startY < 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 21 17 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 21 17 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 72 8135540"); {
				startY = 0;
				start = nHalfDots - Y;
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 73 8135540");  {
				start = 0;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 74 8135540");

			int stop;
			int stopY = Y + nHalfDots;
			if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 75 8135540")|| true) && (stopY > (int) (iH - 1)? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 22 18 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 22 18 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 76 8135540"); {
				stopY = iH - 1;
				stop = nHalfDots + (iH - 1 - Y);
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 77 8135540");  {
				stop = nHalfDots * 2;
			} }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 78 8135540");

			int zoa_cond_n79_0 = 2;
int zoa_cond_n79_1 = 2;
//zoa_cond_n79_0#start > 0$zoa_cond_n79_1#stop < nDots - 1
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 79 8135540")|| true) && ((start > 0?(zoa_cond_n79_0 != (zoa_cond_n79_0 = 1)):(zoa_cond_n79_0 == (zoa_cond_n79_0 = 0))) || (stop < nDots - 1?(zoa_cond_n79_1 != (zoa_cond_n79_1 = 1)):(zoa_cond_n79_1 == (zoa_cond_n79_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 25 19 1 2 ","8135540",true,zoa_cond_n79_0,zoa_cond_n79_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 25 19 0 2 ","8135540",false,zoa_cond_n79_0,zoa_cond_n79_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 80 8135540"); {
				CalTempContrib(start, stop);
				for (int x = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 81 8135540")|| true) && (x < iW? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 26 20 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 26 20 0 0 ","8135540",false,0) && false)); x++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 82 8135540"); {
					value = VerticalFilter(pbImage, startY, stopY, start, stop,
							x, tmpContrib);
					pbOut.setRGB(x, y, value);
				}}
			} } else {  ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 84 8135540");  {
				for (int x = 0; (ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 85 8135540")|| true) && (x < iW? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 27 21 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 27 21 0 0 ","8135540",false,0) && false)); x++){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 86 8135540"); {
					value = VerticalFilter(pbImage, startY, stopY, start, stop,
							x, normContrib);
					pbOut.setRGB(x, y, value);
				}}
			} }

		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 89 8135540");

		return pbOut;

	} // end of VerticalFiltering()

	private int Clip(int x) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 243 90 8135540"); 
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 91 8135540")|| true) && (x < 0? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 28 22 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 28 22 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 92 8135540");
			return 0; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 93 8135540");
		if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 94 8135540")|| true) && (x > 255? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 29 23 1 0 ","8135540",true,1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 243 29 23 0 0 ","8135540",false,0) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 95 8135540");
			return 255; }
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 243 96 8135540");
		return x;
	}

	/**
	 * End: Use Lanczos filter to replace the original algorithm for image
	 * scaling. Lanczos improves quality of the scaled image modify by :blade
	 */

}
