package jarekjal.nauka;

import java.util.Iterator;

public class UnmodifiableBankIterator implements Iterator<BankAccount> {

    private Iterator<BankAccount> iterator;

    public UnmodifiableBankIterator(Iterator<BankAccount> it){
        iterator = it;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public BankAccount next() {
        BankAccount ba =  iterator.next();
        return new UnmodifiableBankAccount(ba);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();

    }
}
