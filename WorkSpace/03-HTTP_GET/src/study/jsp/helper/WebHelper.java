package study.jsp.helper;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;

/*싱글톤객체를 생성하여 리턴한다*/
public class WebHelper {
	
	/*request 내장객체의 참조*/
	private HttpServletRequest request;
	
	/*싱글톤객체시작*/
	private static WebHelper current;
	
	/*싱글톤 객체를 생성하여 리턴한다*/
	public static WebHelper getInstance(HttpServletRequest request){
		try{
			request.setCharacterEncoding("UTF-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		if(current==null){
			current = new WebHelper();
		}
		current.request = request;
		
		return current;
	}
	/*싱글톤 객체를 삭제한다.*/
	public static void freeInstance(){
		current=null;
	}
	
	private WebHelper(){
		
	}
	
	/*파라미터를 전달받아서 리턴한다.*/
	public String getString(String fieldName, String defaultValue){
		String result = defaultValue;
		String param = this.request.getParameter(fieldName);
		
		if(param !=null){
			param = param.trim();
			
			if(!param.equals("")){
				result = param;
			}
		}
		return  result;
	}
	
	/*파라미터를 전달받아서리턴한다. 값이 없을 경우는 null을 리턴한다*/
	public String getString(String fieldName){
		return this.getString(fieldName,null);
	}
	
	/*파라미터를 전달받아서 int로 형변환 하여 리턴한다.*/
	public int getInt(String fieldName, int defaultValue){
		int result = defaultValue;
		String param = this.getString(fieldName);
		
		if(param !=null){
			try{
				result = Integer.parseInt(param);
			}catch(NumberFormatException e){
				
			}			
		}
		return  result;
	} 
	
	/*파라미터를 전달받아서 int로 형변환 하여 리턴한다. */
	public int getInt(String fieldName){
		return this.getInt(fieldName,0);
	}
	
}
