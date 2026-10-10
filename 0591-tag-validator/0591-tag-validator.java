class Solution {
	public boolean isValid(String code) {
		Stack<String> stack = new Stack<>();
		int n = code.length();
		boolean rootClosed = false;

		for (int i = 0; i < n;) {
			if (i > 0 && stack.isEmpty()) {
				return false;
			}

			if (code.startsWith("<![CDATA[", i)) {
				if (stack.isEmpty()) {
					return false;
				}
				int j = code.indexOf("]]>", i + 9);
				if (j == -1) {
					return false;
				}
				i = j + 3;
			} else if (code.startsWith("</", i)) {
				int j = code.indexOf('>', i);
				if (j == -1) {
					return false;
				}
				String tag = code.substring(i + 2, j);
				if (!isValidTagName(tag) || stack.isEmpty()
						|| !stack.pop().equals(tag)) {
					return false;
				}
				i = j + 1;
				if (stack.isEmpty()) {
					rootClosed = true;
					if (i < n) {
						return false;
					}
				}
			} else if (code.charAt(i) == '<') {
				int j = code.indexOf('>', i);
				if (j == -1) {
					return false;
				}
				String tag = code.substring(i + 1, j);
				if (!isValidTagName(tag)) {
					return false;
				}
				stack.push(tag);
				i = j + 1;
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				i++;
			}
		}

		return rootClosed && stack.isEmpty();
	}

	private boolean isValidTagName(String tag) {
		if (tag.length() < 1 || tag.length() > 9) {
			return false;
		}
		for (int i = 0; i < tag.length(); i++) {
			if (tag.charAt(i) < 'A' || tag.charAt(i) > 'Z') {
				return false;
			}
		}
		return true;
	}
}