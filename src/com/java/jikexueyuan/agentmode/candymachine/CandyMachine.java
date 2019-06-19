package com.java.jikexueyuan.agentmode.candymachine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.java.jikexueyuan.agentmode.candymachinermi.CandyMachineRemote;

public class CandyMachine extends UnicastRemoteObject implements CandyMachineRemote{
    //卖完状态
	State mSoldOutState;
	//正在准备状态
	State mOnReadyState;
	//还有硬币
	State mHasCoin;
	//卖完状态
	State mSoldState;
	//胜利状态
	State mWinnerState;
	private String location="";
	//当前正在进行的状态（变化的）
	private State state;
	private int count = 0;

	public CandyMachine(String location,int count) throws RemoteException{
		this.location=location;
		this.count = count;
		//所有的状态激活
		mSoldOutState = new SoldOutState(this);
		mOnReadyState = new OnReadyState(this);
		mHasCoin = new HasCoin(this);
		mSoldState = new SoldState(this);
		mWinnerState = new WinnerState(this);
		if (count > 0) {
			state = mOnReadyState;
		} else {
			state = mSoldOutState;
		}
	}
	public String getLocation()
	{
		return location;
	}
	public void setState(State state) {
		this.state = state;
	}

	public void insertCoin() {
		state.insertCoin();
	}

	public void returnCoin() {
		state.returnCoin();
	}

	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void releaseCandy() {

		// TODO Auto-generated method stub
		if (count > 0) {
			count = count - 1;
			System.out.println("恭喜获胜者得到一个糖果：a candy rolling out!");
		}

	}

	public int getCount() {
		return count;
	}

	public void printstate() {
		state.printstate();
	}
	public State getstate() {
		return state;
	}
}
