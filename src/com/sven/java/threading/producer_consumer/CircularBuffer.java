package com.sven.java.threading.producer_consumer;

public class CircularBuffer implements Buffer {
    private final int[] buffer = {-1,-1,-1};

    private int occupiedCells = 0;
    private int readIdx = 0;
    private int writeIdx = 0;


    @Override
    public synchronized void setValue(int value) throws InterruptedException {

        while(occupiedCells == buffer.length){
            System.out.println("Buffer full. Producer waits ");
            wait();
        }
        buffer[writeIdx] = value;
        writeIdx = (writeIdx +1 ) % buffer.length;
        occupiedCells++;
        displayState("Producer writes "+value);
        notifyAll();
    }


    @Override
    public synchronized int getValue() throws InterruptedException {

        while (occupiedCells == 0){
            System.out.println("Buffer is empty. Consumer waits");
            wait();
        }
        int value = buffer[readIdx];
        readIdx = (readIdx +1) % buffer.length;
        occupiedCells--;
        displayState("Consumer reads "+value);
        notifyAll();
        return value;
    }

    void displayState(String operation) {
        // output operation and number of occupied buffer cells
        System.out.printf( "%s%s%d)\n%s", operation,
                " (buffer cells occupied: ", occupiedCells, "buffer cells: ");
        for ( int value : buffer )
            System.out.printf( "  %2d ", value);
        System.out.print( "\n               " );

        for ( int i = 0; i < buffer.length; i++ )
            System.out.print( "---- " );
        System.out.print( "\n               " );

        for ( int i = 0; i < buffer.length; i++ )
        {
            if ( i == writeIdx && i == readIdx )
                System.out.print( " WR" ); // both write and read index
            else if ( i == writeIdx )
                System.out.print( " W   " ); // just write index
            else if ( i == readIdx )
                System.out.print( "  R  " ); // just read index
            else
                System.out.print( "     " ); // neither index
        } // end for
        System.out.println( "\n" );
    }
}
