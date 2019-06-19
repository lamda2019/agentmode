package com.java.jikexueyuan.agentmode.candymachine;

import java.io.Serializable;

public interface State extends Serializable{
	//插入硬币
	public void insertCoin();
	//返回硬币
	public void returnCoin();
	//摇动曲柄
	public void turnCrank();
	//发放
	public void dispense();
	//打印状态
	public void printstate();
	//获得状态名称
	public String getstatename();
}
