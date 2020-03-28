import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class main
{
    public static void main(String [] args)
    {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder("California", placesToVisit);
        addInOrder("Chicago", placesToVisit);
        addInOrder("NewYork", placesToVisit);
        addInOrder("Alabama", placesToVisit);
        addInOrder("Texas", placesToVisit);
        addInOrder("Morocco", placesToVisit);
        addInOrder("Brazil", placesToVisit);

        printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList)
    {
        // code required to iterate through a linked list
        Iterator<String> iterator = linkedList.iterator();
        while(iterator.hasNext())
        {
            System.out.println("Now visiting " + iterator.next());
        }
        System.out.println("=======================");
    }

    private static boolean addInOrder(String newCity, LinkedList<String> linkedList)
    {
        // an iterator for a linked list of string type
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext())
        {
            // brings a number to compare to
            int comparision = stringListIterator.next().compareTo(newCity);
            if(comparision == 0)
            {
                // they are equal, do not add
                System.out.println(newCity + " already a destination");
                return false;
            }
            else if(comparision > 0 )
            {
                // new city should appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
            else if (comparision < 0)
            {
                // move on to next city

            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty())
        {
            System.out.println("No destination on file");
        }
        else
        {
            System.out.println("now visiting " + listIterator.next());
            printMenu();
        }
        while(!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action)
            {
                case 0:
                    System.out.println("Holiday over!");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now visiting " + listIterator.next());
                    }
                    else
                    {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious())
                    {
                        System.out.println("now visiting " + listIterator.previous());
                    }
                    else
                    {
                        System.out.println("we are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("available list of options");
        System.out.println("0 - quit");
        System.out.println("1 - go to next city");
        System.out.println("2 - go to previous city");
        System.out.println("3 - print the menu");
    }
}
