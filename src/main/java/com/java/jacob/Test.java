package com.java.jacob;

import java.io.IOException;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;




public class Test{
    /**
     * 具体使用可以访问两个博客:
     * http://www.codeweblog.com/%E4%BD%BF%E7%94%A8java%E5%AE%9E%E7%8E%B0%E8%AF%AD%E9%9F%B3%E6%9C%97%E8%AF%BB%E4%B8%80%E6%AE%B5%E6%96%87%E6%9C%AC/
     * http://blog.csdn.net/xichengqc/article/details/78709724
     * jacob.jar是resource目录下jacob下的jar包
     * 将jacob.jar打到本地maven库里
     * mvn install:install-file -Dfile=jacob.jar -DgroupId=com.jacob -DartifactId=jacob -Dversion=1.0 -Dpackaging=jar 
     * @param args
     * @throws IOException
     */
	public static void main(String[] args) throws IOException {  
		//这个Sapi.SpVoice是需要安装什么东西吗，感觉平白无故就来了
	    ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
	    // Dispatch是做什么的？
	    Dispatch sapo = sap.getObject();
	    try {
	        // 音量 0-100
	        sap.setProperty("Volume", new Variant(100));
	        // 语音朗读速度 -10 到 +10
	        sap.setProperty("Rate", new Variant(-2));

	        Variant defalutVoice = sap.getProperty("Voice");

	        Dispatch dispdefaultVoice = defalutVoice.toDispatch();
	        Variant allVoices = Dispatch.call(sapo, "GetVoices");
	        Dispatch dispVoices = allVoices.toDispatch();

	        Dispatch setvoice = Dispatch.call(dispVoices, "Item", new Variant(1)).toDispatch();
	        ActiveXComponent voiceActivex = new ActiveXComponent(dispdefaultVoice);
	        ActiveXComponent setvoiceActivex = new ActiveXComponent(setvoice);

	        Variant item = Dispatch.call(setvoiceActivex, "GetDescription");
	        // 执行朗读
	        Dispatch.call(sapo, "Speak", new Variant("汽车票出票成功量为100，出票成功率为百分之90"));
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        sapo.safeRelease();
	        sap.safeRelease();
	    }
	}
	
}






















