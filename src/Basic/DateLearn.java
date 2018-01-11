package Basic;

import java.util.Date;

import Interface.ILearn;
import Utils.DateUtil;
import Utils.DateUtil.formatEnum;

public class DateLearn  implements ILearn {

	@Override
	public void Example() {
		// TODO Auto-generated method stub
		Date date= new Date();
		System.out.println("���ص�ǰ����:"+DateUtil.Now().toString());
		System.out.println("��ǰ���ڸ�ʽ��:"+DateUtil.nowDefaultFormat());
		System.out.println("��ǰ���ڸ�ʽ��:"+DateUtil.nowFormat(formatEnum.DATE));
		System.out.println("�Զ������ڸ�ʽ��:"+DateUtil.format(DateUtil.Define(2019, 1, 21, 21, 12, 31), formatEnum.DEFAULT) );
		System.out.println("�Զ������ڸ�ʽ��:"+ DateUtil.format(DateUtil.addYears(DateUtil.Now(), 2),formatEnum.DEFAULT));
	}

	@Override
	public void Method() {
		// TODO Auto-generated method stub
		
	}

}
