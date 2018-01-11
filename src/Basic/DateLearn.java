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
		System.out.println("返回当前日期:"+DateUtil.Now().toString());
		System.out.println("当前日期格式化:"+DateUtil.nowDefaultFormat());
		System.out.println("当前日期格式化:"+DateUtil.nowFormat(formatEnum.DATE));
		System.out.println("自定义日期格式化:"+DateUtil.format(DateUtil.Define(2019, 1, 21, 21, 12, 31), formatEnum.DEFAULT) );
		System.out.println("自定义日期格式化:"+ DateUtil.format(DateUtil.addYears(DateUtil.Now(), 2),formatEnum.DEFAULT));
	}

	@Override
	public void Method() {
		// TODO Auto-generated method stub
		
	}

}
