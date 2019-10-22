package utility;

import javax.mail.internet.AddressException;
import org.testng.IExecutionListener;

import utility.BaseClass;

public class BaseHTMLReporter implements IExecutionListener {

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExecutionFinish() {
if (BaseClass.bResult.contains("Fail")) {
         	
         	System.out.println(BaseClass.bResult);
    		    try {
					utility.EmailReport.EmailReportTo();
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         }
         else {
         	try {
				utility.EmailReport.EmailReportOnSuccess();
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
		
	}
         
}
    
 