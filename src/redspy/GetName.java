package redspy;

import java.util.ArrayList;

public interface GetName {

	public String getName();

	static String toSlashSeperatedString(ArrayList<? extends GetName> a) {
		String out = "";
		for (int i = 0; i < a.size(); i++) {
			out += a.get(i).getName();
			if (i < a.size() - 1) {
				out += "/";
			}
		}
		return out;
	}

	static String toCommaSeperatedString(ArrayList<? extends GetName> a) {
		if (a.size() == 0) {
			return "";
		} else if (a.size() == 1) {
			return a.get(0).getName();
		} else if (a.size() == 2) {
			return a.get(0).getName() + " and " + a.get(1).getName();
		} else {
			String out = "";
			for (int i = 0; i < a.size(); i++) {
				out += a.get(i).getName();
				if (i < a.size() - 2) {
					out += ", ";
				} else if (i == a.size() - 2) {
					out += ", and ";
				}
			}
			return out;
		}
	}
	
	/*
	 * returns null if there are no items with that name
	 */
	static GetName getItemWithName(ArrayList<? extends GetName> a, String name) {
		for (GetName n : a) {
			if (n.getName().toLowerCase().equals(name.toLowerCase())) {
				return n;
			}
		}
		return null;
	}
	
}
