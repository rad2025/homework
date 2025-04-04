// Delta College - CST 283 - Klingler & Gaddis Text                  
// This class implements an unordered singly-linked list of objects.

class LinkedList<ItemType>
{
    // --------------------------------------------------------------
    // Private inner class definition of standard data node
    private class Node
    {
        ItemType value;   
        Node next;      

        // Construct node with data and reference to successor
        Node(ItemType val, Node n)
        {
            value = val;
            next = n;
        } 
        
        // Construct node with data null sucessor
        Node(ItemType val)
        {
           this(val, null);            
        }
    }    
    // --------------------------------------------------------------
     
    private Node first;  // list head   
    
    private Node currentPos;  // Current position for iterator action
         
    // --------------------------------------------------------------
    // No-arg constructor for linked list.  Declare empty; null out pointers
    public LinkedList()
    {
        first = null;        
    }
    
    // --------------------------------------------------------------
    // Observer to determine if list empty
    public boolean isEmpty()
    {        
        return first == null;       
    }
    
    // --------------------------------------------------------------
    // Get current (integer) length of list
    public int size()
    {
        int count = 0;
        Node currNode = first;     
        while (currNode != null)
        {
            count++;                    // Increment counter
            currNode = currNode.next;   // Advance to next node
        }
        return count;
    }
    
    // --------------------------------------------------------------
    // Method adds an element to the front of the list
    public void add(ItemType newElementData)
    {
        Node newNode = new Node(newElementData);
        newNode.next = first;
        first = newNode;
    }
     
    // --------------------------------------------------------------
    // Method removes an element by searching for and matching the value
    public boolean remove(ItemType element)
    {
        // Special case:  empty list - do nothing
        if (isEmpty()) 
            return false;      
      
        // Special case: element matched for deletion is first element
        if (element.equals(first.value))
        {
            first = first.next;      
            return true;
        }
      
        // Find the predecessor of the element to remove
        Node pred = first;
        while (pred.next != null && !pred.next.value.equals(element))
        {
            pred = pred.next;
        }

        // If not found return false
        if (pred.next == null)
            return false;
      
        // Otherwise, element found and pred.next.value is element
        pred.next = pred.next.next;     // Bypass element to delete it
      
      
        return true;       
    }
    
    // --------------------------------------------------------------
    // Method searches for existence of target in list using linear 
    // search.  If matching (i.e. equals method returns true) object
    // in list overwrites parameter hence returning entire list object
    // by reference.
    // Param:  target.  Search target.
    // Return:  boolean.  Found target or did not find target
    public boolean contains(ItemType target)
    {
        Node nodePtr = first;
        while (nodePtr != null)
        {
            if (target.equals(nodePtr.value))
                return true;
            nodePtr = nodePtr.next;
        }
        return false;
    }

    // --------------------------------------------------------------
    // Method adds an element to the end of the list
    public void append(ItemType newElementData)
    {
        Node newNode = new Node(newElementData);

        if (isEmpty())
        {
            first = newNode;
        }
        else
        {
            Node curr = first;
            while (curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    // --------------------------------------------------------------
    // The toString method computes the string representation of the list.
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
      
        // Use currPos to walk down the linked list
        Node currPos = first;
        while (currPos != null)
        {
            strBuilder.append(currPos.value + " -> ");
            currPos = currPos.next;
        }
        strBuilder.append("NULL");
        return strBuilder.toString(); 
    }
    


}
