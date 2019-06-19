package com.java.jikexueyuan.agentmode;

import java.rmi.RemoteException;

import com.java.jikexueyuan.agentmode.candymachine.CandyMachine;

public class MainTest {
	public static void main(String[] args) throws RemoteException {
		Monitor mMonitor=new Monitor();
		CandyMachine mCandyMachine = new CandyMachine("NY",6);
		//因为count为6，则把NY的mOnReadyState放入队列
		mMonitor.addMachine(mCandyMachine);
		
		mCandyMachine = new CandyMachine("TK",4);
		//调用mOnReadyState的insertCoin()方法
		mCandyMachine.insertCoin();
		//把TK检查是否还有硬币的状态放入队列
		mMonitor.addMachine(mCandyMachine);


		mCandyMachine = new CandyMachine("Bj",14);
		//调用mOnReadyState的insertCoin()方法
		mCandyMachine.insertCoin();
		//调用mHasCoin的turnCrank()方法,有十分之一的可能性中奖
		mCandyMachine.turnCrank();
		//如果中奖调用mWinnerState的dispense()方法把mOnReadyState（count>0）状态放入队列，
		//如果没中奖，把mSoldState的dispense()方法把mOnReadyState（count>0）状态放进队列
		mMonitor.addMachine(mCandyMachine);

		//遍历队列中的不同地点的状态
		mMonitor.report();
	}
}
