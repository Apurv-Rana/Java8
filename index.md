## Welcome to an Intresting world of java

First we will be exploring the most critical part used in industry, i.e, Collections.

Girst we will be talking about the enhancment done as a part of collection framework 
# 1.6 verison enhancement 

as a part of 1.6 version the following two concepts introduced in collection framework
1. navigable set
2. navigable map

## Navigable set:
it is the child interface of sortedSet and it  defines several methods for navigation purposes .
NavigableSet represents a navigable set in Java Collection Framework. The NavigableSet interface inherits from the SortedSet interface. It behaves like a SortedSet with the exception that we have navigation methods available in addition to the sorting mechanisms of the SortedSet. For example, NavigableSet interface can navigate the set in reverse order compared to the order defined in SortedSet.

The classes that implement this interface are, TreeSet and ConcurrentSkipListSet

### Methods of NavigableSet (Not in SortedSet):

   - Lower(E e) : Returns the greatest element in this set which is less than the given element or NULL if there is no such element.
   - Floor(E e ) : Returns the greatest element in this set which is less than or equal to given element or NULL if there is no such element.
   -Ceiling(E e) : Returns the least element in this set which is greater than or equal to given element or NULL if there is no such element.
   - Higher(E e) : Returns the least element in this set which is greater than the given element or NULL if there is no such element.
   -pollFirst() : Retrieve and remove the first least element. Or return null if there is no such element.
   - pollLast() : Retrieve and remove the last highest element. Or return null if there is no such element.

```
import java.util.NavigableSet;
import java.util.TreeSet;
 
public class hashset 
{
    public static void main(String[] args) 
    {
        NavigableSet<Integer> ns = new TreeSet<>();
        ns.add(0);
        ns.add(1);
        ns.add(2);
        ns.add(3);
        ns.add(4);
        ns.add(5);
        ns.add(6);
 
        // Get a reverse view of the navigable set
        NavigableSet<Integer> reverseNs = ns.descendingSet();
 
        // Print the normal and reverse views
        System.out.println("Normal order: " + ns);
        System.out.println("Reverse order: " + reverseNs);
 
        NavigableSet<Integer> threeOrMore = ns.tailSet(3, true);
        System.out.println("3 or  more:  " + threeOrMore);
        System.out.println("lower(3): " + ns.lower(3));
        System.out.println("floor(3): " + ns.floor(3));
        System.out.println("higher(3): " + ns.higher(3));
        System.out.println("ceiling(3): " + ns.ceiling(3));
 
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
 
        System.out.println("pollLast(): " + ns.pollLast());
        System.out.println("Navigable Set:  " + ns);
 
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
 
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
 
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
 
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("pollLast(): " + ns.pollLast());
    }
}

Output:


Normal order: [0, 1, 2, 3, 4, 5, 6]
Reverse order: [6, 5, 4, 3, 2, 1, 0]
3 or  more:  [3, 4, 5, 6]
lower(3): 2
floor(3): 3
higher(3): 4
ceiling(3): 3
pollFirst(): 0
Navigable Set:  [1, 2, 3, 4, 5, 6]
pollLast(): 6

```

# navigable map:

navigable interface is the child interface of sorted map
it defines several methods for navigation purposes .



## NavigableMap Interface in Java with Example

NavigableMap is an extension of SortedMap which provides convenient navigation method like lowerKey, floorKey, ceilingKey and higherKey, and along with these popular navigation method it also provide ways to create a Sub Map from existing Map in Java e.g. headMap whose keys are less than specified key, tailMap whose keys are greater than specified key and a subMap which is strictly contains keys which falls between toKey and fromKey.

An example class that implements NavigableMap is TreeMap.

## Methods of NavigableMap:

   - lowerKey(Object key) : Returns the greatest key strictly less than the given key, or if there is no such key.
   - floorKey(Object key) : Returns the greatest key less than or equal to the given key, or if there is no such key.
   - ceilingKey(Object key) : Returns the least key greater than or equal to the given key, or if there is no such key.
   - higherKey(Object key) : Returns the least key strictly greater than the given key, or if there is no such key.
   - descendingMap() : Returns a reverse order view of the mappings contained in this map.
   - headMap(object toKey, boolean inclusive) : Returns a view of the portion of this map whose keys are less than (or equal to, if inclusive is true) toKey.
   - subMap(object fromKey, boolean fromInclusive, object toKey, boolean toInclusive) : Returns a view of the portion of this map whose keys range from fromKey to toKey.
   - tailMap(object fromKey, boolean inclusive) : Returns a view of the portion of this map whose keys are greater than (or equal to, if inclusive is true) fromKey.

```
// Java program to demonstrate NavigableMap
import java.util.NavigableMap;
import java.util.TreeMap;
 
public class Example
{
    public static void main(String[] args)
    {
        NavigableMap<String, Integer> nm =
                          new TreeMap<String, Integer>();
        nm.put("C", 888);
        nm.put("Y", 999);
        nm.put("A", 444);
        nm.put("T", 555);
        nm.put("B", 666);
        nm.put("A", 555);
 
        System.out.printf("Descending Set  : %s%n",
                                nm.descendingKeySet());
        System.out.printf("Floor Entry  : %s%n",
                                nm.floorEntry("L"));
        System.out.printf("First Entry  : %s%n",
                                nm.firstEntry());
        System.out.printf("Last Key : %s%n",
                                nm.lastKey());
        System.out.printf("First Key : %s%n",
                                nm.firstKey());
        System.out.printf("Original Map : %s%n", nm);
        System.out.printf("Reverse Map : %s%n",
                                 nm.descendingMap());
    }
}

Output:

Descending Set : [Y, T, C, B, A]
Floor Entry : C=888
First Entry : A=555
Last Key : Y
First Key : A
Original Map : {A=555, B=666, C=888, T=555, Y=999}
Reverse Map : {Y=999, T=555, C=888, B=666, A=555}

```

# Collections Class 
collection class defines several utility methods for collection objects like sorting ,searching, reversing etc.


sorting elements of list:
1. public static void  sort(List l)
object should be homogenous and comparable otherwise we will get class cast exception

list should not contain null otherwise we will get null pointer exception.
2. public static void sort(List l,Comparator c)
customised sorting order 


searching elements of list:
public static int binarySearch(List l,object searching object)
public static int binarySearch(List l,object searching object,Comparator c)

internally uses binary search algorithm

REVERSE()
REVERSEORDER()









```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [Basic writing and formatting syntax](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/Apurv-Rana/Java8/settings/pages). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/) or [contact support](https://support.github.com/contact) and we’ll help you sort it out.
