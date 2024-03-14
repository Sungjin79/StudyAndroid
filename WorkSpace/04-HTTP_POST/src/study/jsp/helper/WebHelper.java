package study.jsp.helper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

/*싱글톤객체를 생성하여 리턴한다*/
public class WebHelper {
	
	/*request 내장객체의 참조*/
	private HttpServletRequest request;
	
	/*out  내장객체의 참조*/
	private JspWriter out;
	
	/*싱글톤객체시작*/
	private static WebHelper current;
	
	/*싱글톤 객체를 생성하여 리턴한다*/
	public static WebHelper getInstance(HttpServletRequest request,JspWriter out){
		try{
			request.setCharacterEncoding("UTF-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		if(current==null){
			current = new WebHelper();
		}
		current.request = request;
		current.out = out;
		
		return current;
	}
	
	
	/*메시지 표시 후, 페이지를 지정된 곳으로 이동한다.
	 * @param url - 이동할 페이지의 URL, Null일 경우 이전페이지로 이동
	 * @param msg - 화면에 표시할 메시지, Null일 경우 표시안함
	 */
	public void redirect(String url, String msg){
		String html = "<!doctype html>";
		html +="<html>";
		html +="<head>";
		html +="<meta charset='utf-8'>";
		
		//메시지 표시
		if(msg !=null){
			html +="<script type='text/javascript'>alert('"+msg+"');</script>";
		}
		//페이지 이동url
		if(url !=null){
			html +="<meta http-equiv='refresh' content='0' url='"+url+"' />";
		}else{
			html +="<script type='text/javascript'>";
			html +="history.back()";
			html +="</script>";
		}
		
		html +="</head>";
		html +="<body></body>";
		html +="</html>";
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