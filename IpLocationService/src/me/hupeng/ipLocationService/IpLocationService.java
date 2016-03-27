package me.hupeng.ipLocationService;


import com.google.gson.Gson;


/**
* 处理用户位置信息的业务逻辑类
* @author HUPENG
* @version 1.0.0
* @since jdk1.7
* */
public  class IpLocationService {
	
	private IpLocationResult ipLocationResult;
	
	/**
	 * 以ip地址获取地理位置信息等，返回一个对象模型
	 * @param ipAddress ip地址，形式诸如 	123.123.123.123
	 * */
	public IpLocationResult getIpLocationResult(String ipAddress){
		if (ipLocationResult!=null) {
			return ipLocationResult;
		}
		String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
		String param = "format=json&ip=" + ipAddress;
		String httpResponse = null;
		try {
			httpResponse = HttpRequest.sendGet(url, param);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("发送GET请求时发生错误");
			e.printStackTrace();
		}
		
		try {
			ipLocationResult= new Gson().fromJson(httpResponse, IpLocationResult.class);
			return ipLocationResult;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("解析json字符串时发生错误");
			e.printStackTrace();
			return null;
		}
	}
}
