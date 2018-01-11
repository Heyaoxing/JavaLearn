package Basic;

import java.rmi.RemoteException;

import Interface.ILearn;

public class throwLearn implements ILearn  {

	@Override
	public void Example() {
		try {
			test() ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Method() {
		// TODO Auto-generated method stub
		
	}
	
	public void test() throws RemoteException{
		throw new RemoteException();
	}

}
