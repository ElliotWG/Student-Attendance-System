package info;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Speak {
	
	public void speak_tts(String tts){

	ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");

	Dispatch sapo = sap.getObject();try

	{

		// ���� 0-100
		sap.setProperty("Volume", new Variant(100));
		// �����ʶ��ٶ� -10 �� +10
		sap.setProperty("Rate", new Variant(2));

		// ִ���ʶ�
		Dispatch.call(sapo, "Speak", new Variant(tts));

	} catch(

	Exception e)

	{
		e.printStackTrace();
	} finally

	{
		sapo.safeRelease();
		sap.safeRelease();
	}
}
}
