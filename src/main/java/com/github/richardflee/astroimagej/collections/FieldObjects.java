package com.github.richardflee.astroimagej.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.github.richardflee.astroimagej.data_objects.CatalogSettings;
import com.github.richardflee.astroimagej.data_objects.FieldObject;

public class FieldObjects {
	
	private List<FieldObject> fos;
	
	public FieldObjects() {
		this.fos = new ArrayList<>();
	}
	
	
	public void addFieldObjects(List<FieldObject> fos) {
		this.fos.addAll(fos);
	}
	
	
//	public void updateComputedFields(FieldObject target) {
//		this.fos.stream().forEach(p -> p.setRadSepAmin(target));
//		this.fos.stream().forEach(p -> p.setDeltaMag(target));
//		
//		System.out.println((fos));
//		
//	}
	
	public void sortByDistance(FieldObject target) {
		
//		this.fos = this.fos.stream()
//			.sorted(Comparator.comparingDouble(p -> p.getRadSepAmin(target)))
//				.collect(Collectors.toList());

		System.out.println("sort by distance");
		
	}
	
	public void sortByDeltaMag(FieldObject target) {
		System.out.println("sort by delta");
		
	}
	
	public int getTotalCount() {
		return this.fos.size();
	}
	
	public int getFilteredCount() {
		long count = this.fos.stream()
				.filter(p -> p.isFiltered())
				.count();
		return Math.toIntExact(count);		
	}
	
	public int getSelectedCount() {		
		long count = this.fos.stream()
				.filter(p -> p.isFiltered())
				.filter(p -> p.isSelected())
				.count();
		return Math.toIntExact(count);	 
	}
	
	@Override
	public String toString() {
		var s = "";
		for (var fo : fos) {
			s += fo.toString() + "\n";
		}
		return s;
	}
	

	

}
