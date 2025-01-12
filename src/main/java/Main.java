class Main {



  public static Node<Integer> q1_list2(Node<Integer> l1, Node<Integer> l2)
	{
		if (l1 == null) return l2; // אם L1 ריקה, להחזיר את L2
	    if (l2 == null) return l1; // אם L2 ריקה, להחזיר את L1

	    Node<Integer> dummy = new Node<>(-1); // ראש זמני לרשימה החדשה
	    Node<Integer> current = dummy; // מצביע לעדכון הרשימה החדשה

	    while (l1 != null && l2 != null) {
	        if (l1.getValue() <= l2.getValue()) { // אם הערך ב-L1 קטן או שווה לערך ב-L2
	            current.setNext(new Node<>(l1.getValue())); // להוסיף את הערך ל-L3
	            l1 = l1.getNext(); // לעבור לחוליה הבאה ב-L1
	        } else {
	            current.setNext(new Node<>(l2.getValue())); // להוסיף את הערך ל-L3
	            l2 = l2.getNext(); // לעבור לחוליה הבאה ב-L2
	        }
	        current = current.getNext(); // לעדכן את המצביע לחוליה הבאה ב-L3
	    }

	    // אם נותרו חוליות ב-L1 או ב-L2, לחבר אותן לסוף L3
	    if (l1 != null) {
	        current.setNext(l1);
	    } else if (l2 != null) {
	        current.setNext(l2);
	    }

	    return dummy.getNext(); // להחזיר את הרשימה החדשה בלי הראש הזמני
	}
	
	public static Node<Integer> q2_list2(Node<Integer> head)
	{
		if (head == null) {
	        return null; // אם הרשימה ריקה, אין מה למיין
	    }

	    Node<Integer> sortedList = new Node<>(-1); // ראש זמני לרשימה החדשה
	    Node<Integer> tail = sortedList; // מצביע לחוליה האחרונה ברשימה החדשה

	    while (head != null) {
	        // חיפוש החוליה עם הערך המינימלי
	        Node<Integer> minNode = head;
	        Node<Integer> prevMin = null;
	        Node<Integer> current = head;
	        Node<Integer> prev = null;

	        while (current != null) {
	            if (current.getValue() < minNode.getValue()) {
	                minNode = current;
	                prevMin = prev;
	            }
	            prev = current;
	            current = current.getNext();
	        }

	        // הסרת החוליה עם הערך המינימלי מהרשימה המקורית
	        if (prevMin == null) {
	            head = head.getNext(); // אם המינימום הוא הראש, עדכן את הראש
	        } else {
	            prevMin.setNext(minNode.getNext());
	        }

	        // הוספת החוליה עם הערך המינימלי לסוף הרשימה החדשה
	        tail.setNext(new Node<>(minNode.getValue()));
	        tail = tail.getNext();
	    }

	    return sortedList.getNext(); // החזרת הרשימה החדשה ללא הראש הזמני
	}
	
	
	
	
	public static int q3_list2(Node<Integer> head, int value)
	{
		if (head == null) {
	        return -1; // אם הרשימה ריקה, הערך לא קיים
	    }

	    int index = 0; // מונה למעקב אחרי המיקום הנוכחי
	    int length = 0; // חישוב אורך הרשימה
	    int sum = 0; // סכום המרחקים
	    boolean found = false; // דגל כדי לבדוק אם הערך נמצא

	    // שלב 1: חישוב אורך הרשימה
	    Node<Integer> current = head;
	    while (current != null) {
	        length++;
	        current = current.getNext();
	    }

	    // שלב 2: מציאת המרחקים של המופעים של הערך
	    current = head; // לאתחל שוב את המצביע לראש הרשימה
	    while (current != null) {
	        if (current.getValue() == value) {
	            found = true;
	            int distanceFromStart = index;
	            int distanceFromEnd = length - index - 1;
	            sum += distanceFromStart + distanceFromEnd;
	        }
	        index++;
	        current = current.getNext();
	    }

	    return found ? sum : -1; // אם הערך נמצא, החזר את הסכום, אחרת החזר -1
	}
	
	
	
	public static boolean q4_list2(Node<Integer> head)
	{
		if (head == null) {
	        return true; // רשימה ריקה נחשבת כבעלת איברים ייחודיים
	    }

	    Set<Integer> seen = new HashSet<Integer>(); // קבוצה לאחסון ערכים שנמצאו ברשימה
	    Node<Integer> current = head;

	    while (current != null) {
	        if (seen.contains(current.getValue())) {
	            return false; // אם הערך כבר נמצא בקבוצה, הרשימה אינה ייחודית
	        }
	        seen.add(current.getValue()); // הוספת הערך לקבוצה
	        current = current.getNext(); // מעבר לחוליה הבאה
	    }

	    return true; // כל האיברים ייחודיים
	}
	
	
	
	public static Node<Integer> q5_list2(Node<Integer> head)
	{
		if (head == null) {
	        return null; // אם הרשימה ריקה, החזר null
	    }

	    Set<Integer> seen = new HashSet<>(); // קבוצה לאחסון ערכים שכבר נצפו
	    Node<Integer> newHead = new Node<>(-1); // ראש זמני לרשימה החדשה
	    Node<Integer> currentNew = newHead; // מצביע לעדכון הרשימה החדשה
	    Node<Integer> current = head;

	    while (current != null) {
	        if (!seen.contains(current.getValue())) {
	            seen.add(current.getValue()); // להוסיף את הערך לקבוצה
	            currentNew.setNext(new Node<>(current.getValue())); // ליצור חוליה חדשה
	            currentNew = currentNew.getNext(); // לעבור לחוליה החדשה ברשימה
	        }
	        current = current.getNext(); // לעבור לחוליה הבאה ברשימה המקורית
	    }

	    return newHead.getNext(); // להחזיר את הרשימה החדשה (ללא הראש הזמני)
	}
	
	
	
	public static int q6_list2(Node<Integer> head)
	{
		if (head == null) {
	        return 0; // אם הרשימה ריקה, אין סדרה
	    }

	    int maxLength = 1; // האורך המקסימלי של סדרה עולה חלש
	    int currentLength = 1; // האורך של הסדרה הנוכחית
	    Node<Integer> current = head;

	    while (current.getNext() != null) {
	        if (current.getValue() <= current.getNext().getValue()) {
	            currentLength++; // הערך הבא >= הערך הנוכחי, הארך את הסדרה
	            maxLength = Math.max(maxLength, currentLength); // עדכן את האורך המקסימלי
	        } else {
	            currentLength = 1; // סדרה חדשה מתחילה
	        }
	        current = current.getNext(); // עבור לחוליה הבאה
	    }

	    return maxLength; // החזר את אורך הסדרה הארוכה ביותר
	}
	
	
	
	
	public static void q7_list2(Node<Integer> l1, Node<Integer> l2)
	{
		 if (head == null) {
		        System.out.println("The list is empty.");
		        return;
		    }

		    Node<Integer> current = head;
		    Node<Integer> startOfLongest = head; // מצביע לתחילת הסדרה הארוכה ביותר
		    Node<Integer> startOfCurrent = head; // מצביע לתחילת הסדרה הנוכחית
		    int maxLength = 1; // אורך הסדרה הארוכה ביותר
		    int currentLength = 1; // אורך הסדרה הנוכחית

		    while (current.getNext() != null) {
		        if (current.getValue() <= current.getNext().getValue()) {
		            currentLength++; // הערך הבא >= הערך הנוכחי
		            if (currentLength > maxLength) {
		                maxLength = currentLength; // עדכן את האורך המקסימלי
		                startOfLongest = startOfCurrent; // עדכן את תחילת הסדרה הארוכה ביותר
		            }
		        } else {
		            currentLength = 1; // התחלת סדרה חדשה
		            startOfCurrent = current.getNext(); // עדכן את תחילת הסדרה הנוכחית
		        }
		        current = current.getNext(); // עבור לחוליה הבאה
		    }

		    // הדפס את הסדרה הארוכה ביותר
		    System.out.print("Longest non-decreasing sequence: ");
		    for (int i = 0; i < maxLength; i++) {
		        System.out.print(startOfLongest.getValue() + " ");
		        startOfLongest = startOfLongest.getNext();
		    }
		    System.out.println();
	}
	
	
	
	public static boolean q8_list2(Node<Integer> l1, Node<Integer> l2)
	{
		 if (l1 == null || l2 == null) {
		        return false; // אם אחת הרשימות ריקה, לא ניתן לבדוק חזרות
		    }

		    // בודקים אם כל האיברים ב-l2 הם חזרות של L1
		    Map<Integer, Integer> l1Frequency = new HashMap<>();
		    Node<Integer> currentL1 = l1;

		    // סופר את תדירות כל ערך ב-L1
		    while (currentL1 != null) {
		        l1Frequency.put(currentL1.getValue(), l1Frequency.getOrDefault(currentL1.getValue(), 0) + 1);
		        currentL1 = currentL1.getNext();
		    }

		    // בודקים אם כל הערכים ב-L2 קיימים ב-L1 בצורה נכונה
		    Node<Integer> currentL2 = l2;
		    while (currentL2 != null) {
		        int value = currentL2.getValue();
		        if (!l1Frequency.containsKey(value) || l1Frequency.get(value) <= 0) {
		            return false; // אם ערך לא נמצא ב-L1 או שהתדירות שלו נגמרה
		        }
		        l1Frequency.put(value, l1Frequency.get(value) - 1); // פחות 1 מהתדירות
		        currentL2 = currentL2.getNext();
		    }

		    // אם כל הערכים ב-L2 עונים על הדרישות
		    return true;
	}

	public static boolean q9_list2(Node<Integer> l1, Node<Integer> l2)
	{
		if (l1 == null) {
	        return true; // אם L1 ריקה, כל רשימה מכילה אותה
	    }
	    if (l2 == null) {
	        return false; // אם L2 ריקה, היא לא יכולה להכיל L1
	    }

	    Node<Integer> currentL2 = l2;
	    while (currentL2 != null) {
	        Node<Integer> currentL1 = l1;
	        Node<Integer> tempL2 = currentL2;

	        // בדוק אם יש רצף מתאים של L1 ב-L2
	        while (currentL1 != null && tempL2 != null && currentL1.getValue() == tempL2.getValue()) {
	            currentL1 = currentL1.getNext();
	            tempL2 = tempL2.getNext();
	        }

	        // אם הגענו לסוף של L1, מצאנו את הרצף
	        if (currentL1 == null) {
	            return true;
	        }

	        currentL2 = currentL2.getNext(); // עבר לחוליה הבאה ב-L2
	    }

	    return false; // אם לא מצאנו את הרצף
	}
	
	
	
	public static boolean q10_list2(Node<Integer> head)
	{
		boolean[] seen = new boolean[10]; // מערך עזר בגודל 10, כל ערך יוקצה למיקומו במערך

	    Node<Integer> current = head;
	    while (current != null) {
	        int value = current.getValue();
	        if (value >= 1 && value <= 10) {
	            seen[value - 1] = true; // מסמנים את הערך במערך העזר
	        }
	        current = current.getNext();
	    }

	    // אם כל הערכים מ-1 עד 10 הופיעו, כל המיקומים במערך צריכים להיות true
	    for (int i = 0; i < 10; i++) {
	        if (!seen[i]) {
	            return false; // אם יש ערך מ-1 עד 10 שלא הופיע
	        }
	    }

	    return true; // כל הערכים מ-1 עד 10 הופיעו לפחות פעם אחת
	}
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
