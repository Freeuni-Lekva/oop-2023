public class BitmaskFilter implements Filter{
    int[] mask;
    int numPresents;

    // Rep invariant:
    //   i % 32 -th bit of masks[i / 32] is one iff i-th element is marked as present
    //   numPresent equals to number of set bits in stored bit masks
    // Abstraction function:
    //   Represents set of present elements

    public BitmaskFilter() {
        mask = new int[4];
        numPresents = 0;
    }

    @Override
    public int size() {
        return numPresents;
    }

    @Override
    public boolean isPresent(int index) {
        int n = index / 32;
        int m = index % 32;

        return (mask[n] & (1 << (31 - m))) != 0; // > 0 არის ბაგი. რადგან უარყოფით რიცხვად აღიქვამს თუ მე-0 ბიტს დავსეტავთ და შევამოწმებთ. ამის დაჭერა testIsPresent ტესტით შეგვიძლია.
    }

    @Override
    public void add(int index) {
        int n = index / 32;
        int m = index % 32;

        if (index > mask.length * 32) { // პირობა სხვანაირად: n >= mask.length
            int [] tmp = new int[Math.max(n + 1, 2 * mask.length)];
            System.arraycopy(mask, 0, tmp, 0, mask.length);
            mask = tmp;
        }

        numPresents++;
        mask[n] |= 1 << (31 - m);
    }

    @Override
    public void remove(int index) {
        if (index > mask.length * 32) { // პირობა სხვანაირად: n >= mask.length
            return;
        }
        int n = index / 32;
        int m = index % 32;

        mask[n] &= ~(1 << (31 - m)); // 31 და არა 32, რადგან 0-დან ვიწყებთ ბიტების ინდექსაციას
    }
}
