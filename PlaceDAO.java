package com.mysqldemoproject.open.DAO;

import java.util.List;

import com.mysqldemoproject.open.model.ExcelData;
import com.mysqldemoproject.open.model.Place;

public interface PlaceDAO {

			public int addPlace(Place place);
			List <Object[]> getPlaceDetail(int state_id);
			public void saveExcel(ExcelData ex_data);
}
