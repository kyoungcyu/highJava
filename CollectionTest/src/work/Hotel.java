package work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


	public class Hotel {
	    private int roomNum; 
	    private String underName;
	    private Map<Integer, String> checkinUser;


	    public Hotel() {
	        checkinUser = new HashMap<>();
	    }
	    public void roomStates() {
			// TODO Auto-generated method stub
			
		}
		//Getter Setter

	    public int getRoomNum() {
	        return roomNum;
	    }

	    public void setRoomNum(int roomNum) {
	        this.roomNum = roomNum;
	    }

	    public String getUnderName() {
	        return underName;
	    }

	    public void setUnderName(String underName) {
	        this.underName = underName;
	    }

	    public Map<Integer, String> getCheckinUser() {
	        return checkinUser;
	    }

	    public void setCheckinUser(Map<Integer, String> checkinUser) {
	        this.checkinUser = checkinUser;
	    }


	 
	    public boolean checkin() {   // 체크인
	        if (checkinUser.get(roomNum) != null) {
	            return false;
	        }
	        checkinUser.put(roomNum, underName);
	        return true;
	    }


	    public void checkout(int roomNum) {    // 체크아웃
	        if (checkinUser.get(roomNum) == null) {
	            System.out.println(roomNum + "방에는 체크인한 사람이 없습니다");
	        } else {
	            checkinUser.remove(roomNum);
	            System.out.println("체크아웃 되었습니다");
	        }
	    }

	   
	    public void roomCondition() { // 객실상태
	        Set<Integer> keySet = checkinUser.keySet();
	        if (checkinUser.values().size() != 0) {
	            for (Integer integer : keySet) {
	                System.out.println("방번호 : " + integer + ", 투숙객 : " + checkinUser.get(integer));
	            }
	        } else {
	            System.out.println("현재 체크인된 방이 없습니다");
	        }
	    }

	}

