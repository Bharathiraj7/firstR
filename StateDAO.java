package com.mysqldemoproject.open.DAO;
import java.util.List;

import com.mysqldemoproject.open.model.State;

public interface StateDAO {

				public  int stateAdd(State st);
				public List <State> getStateDetails();
			   public List <State> getState_Country(int country_id);
			  public State getStateId(int state_id);
}
