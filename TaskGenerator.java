public class TaskGenerator {
    public static void main(String[] args) {
        hashMap Tasks = new hashMap(3);
        String[] TaskKeys = new String[3];
        Stack lastApps = new Stack(3);

        loadApps(Tasks, TaskKeys);
        saveApps(Tasks, TaskKeys, lastApps);
        memKiller(Tasks, TaskKeys);
        System.out.println("The last saved app is " + lastSavedApp(lastApps));
    }

    static void loadApps(hashMap Tasks, String[] TaskKeys) {
        Tasks.insert("XWord", "Word Processor");
        TaskKeys[0] = "XWord";
        Tasks.insert("XMaps", "Navigation App");
        TaskKeys[1] = "XMaps";
        Tasks.insert("Xyxtem", "System");
        TaskKeys[2] = "Xyxtem";
    }

    static void memKiller(hashMap Tasks, String[] TaskKeys) {
        int operationSuccess = 0;
        for (int a = 0; a < TaskKeys.length; a++) {
            Tasks.remove(TaskKeys[a]);
            if (Tasks.lookup(TaskKeys[a]) == null) {
                operationSuccess++;
            }
        }
        if (operationSuccess == TaskKeys.length) {
            System.out.println("Task deleted successfully");
        }
    }

    static void saveApps(hashMap Tasks, String[] TaskKeys, Stack LastApps) {
        for (int a = TaskKeys.length - 1; a >= 0; a--) {
            LastApps.push(Tasks.lookup(TaskKeys[a]));
        }
    }

    static String lastSavedApp(Stack lastApps) {
        return lastApps.peek();
    }
}

// Worst time complexity: O(n)
class hashMap {
    private int tableSize; // is used for getting the size for HashTable
    private String[] table; // is the HashTable

    // The constructor assigns size of the HashTable
    public hashMap(int size) {
        tableSize = size;
        table = new String[tableSize];
    }

    // Get the ASCII code of each character and divide them by TableSize and return
    // the remainder
    // Worst-case time complexity: O(n)
    public int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % tableSize;
    }

    // Insert function shall get the index from hash and assign an index into an
    // array then value will be inserted into that location
    // Worst-case time complexity: O(n)
    public void insert(String key, String value) {
        int index = hash(key);
        table[index] = value;
    }

    // Key will be used to get the index and the index will return the associated
    // value
    // Worst-case time complexity: O(n)
    public String lookup(String key) {
        int index = hash(key);
        return table[index];
    }

    // Remove function shall remove the value based on its key
    // Worst-case time complexity: O(n)
    public void remove(String key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index] = null;
        }
    }

    public int size() {
        return table.length;
    }
}

// Worst time complexity: O(1)
// Worst space complexity: O(n)
class Stack {
    private int maxSize; // Maximum size of the stack
    private int top; // Index of the top element in the stack
    private String[] stackArray; // The array that will be used for Stack

    // Get the size and initialize the array and top
    public Stack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1; // Initialize the top index to -1 (empty stack)
    }

    // Worst-case time complexity: O(1)
    // Push the item into Stack
    public void push(String item) {
        if (top < maxSize - 1) { // If the size is greater than top increment the top and assign item
            stackArray[++top] = item;
        } else { // If top is greater or equal to maxSize do not accept any item
            System.out.println("Stack is full. Cannot push " + item);
        }
    }

    // Worst-case time complexity: O(1)
    // This function removes item from stack
    public String pop() {
        if (top >= 0) { // Top is always greater than 0 when there are items in stack therefore
                        // decrement top
            return stackArray[top--];
        } else { // Otherwise give error and return null
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
    }

    // Worst-case time complexity: O(1)
    // This finds the top of the stack
    public String peek() {
        if (top >= 0) { // If the top is greater than 0 return the value
            return stackArray[top];
        } else { // Otherwise give error and return null
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
    }

    // Worst-case time complexity: O(1)
    // Return whether the stack is empty or not
    public boolean isEmpty() {
        return top == -1;
    }

    // Worst-case time complexity: O(1)
    // Get the size of the stack
    public int size() {
        return top + 1;
    }
}