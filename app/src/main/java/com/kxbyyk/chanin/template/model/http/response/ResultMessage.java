package com.kxbyyk.chanin.template.model.http.response;


import com.google.gson.Gson;

public class ResultMessage<T> {
	
	public static final int SUCCESS = 1000;
	public static final int FAIL = 2000;
	public static final int AUTH_FAIL = 3000;

	private int resultCode;//结果代码
	private String resultMsg;//结果描述
	private Long serverTime;//服务器时间
	private int spendTime;//花费时间 

	private T data;//数据
	private Gson gson;


	public ResultMessage() {

	}

	public ResultMessage(int resultCode, String resultMsg) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	public ResultMessage(int resultCode, String resultMsg, T data) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.data = data;
	}



	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}


	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Long getServerTime() {
		return serverTime;
	}

	public void setServerTime(Long serverTime) {
		this.serverTime = serverTime;
	}

	public int getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(int spendTime) {
		this.spendTime = spendTime;
	}


	@Override
	public String toString() {
		gson = new Gson();
		return "ResultMessage{" +
				"resultCode=" + resultCode +
				", resultMsg='" + resultMsg + '\'' +
				", serverTime=" + serverTime +
				", spendTime=" + spendTime +
				", data=" + gson.toJson(data) +
				'}';
	}
}
