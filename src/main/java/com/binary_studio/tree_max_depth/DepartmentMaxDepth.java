package com.binary_studio.tree_max_depth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DepartmentMaxDepth {

	private DepartmentMaxDepth() {
	}

	public static Integer calculateMaxDepth(Department rootDepartment) {
		Department department = rootDepartment;
		if (department.subDepartments.size() == 0)
			return 0;
		else
		{
			List<Integer> depths = new ArrayList<>();
			for (Department subDepartment : department.subDepartments) {
				depths.add(calculateMaxDepth(subDepartment));
			}
			return Collections.max(depths) + 1;
		}
	}

}
