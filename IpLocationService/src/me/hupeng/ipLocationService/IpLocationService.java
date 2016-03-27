package me.hupeng.ipLocationService;


import com.google.gson.Gson;


/**
* �����û�λ����Ϣ��ҵ���߼���
* @author HUPENG
* @version 1.0.0
* @since jdk1.7
* */
public  class IpLocationService {
	
	private IpLocationResult ipLocationResult;
	
	/**
	 * ��ip��ַ��ȡ����λ����Ϣ�ȣ�����һ������ģ��
	 * @param ipAddress ip��ַ����ʽ���� 	123.123.123.123
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
			System.err.println("����GET����ʱ��������");
			e.printStackTrace();
		}
		
		try {
			ipLocationResult= new Gson().fromJson(httpResponse, IpLocationResult.class);
			return ipLocationResult;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("����json�ַ���ʱ��������");
			e.printStackTrace();
			return null;
		}
	}
}
