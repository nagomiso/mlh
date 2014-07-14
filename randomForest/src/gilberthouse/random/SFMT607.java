package gilberthouse.random;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A SIMD-oriented Fast Mersenne Twister generator.
 */
public class SFMT607 extends AbstractGenerator implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6625136322169575730L;
    /**
     * The jump polynomial (2<sup>32</sup> steps).
     */
    public static final JumpPolynomial JUMP_EXP2_32 = new JumpPolynomial("88712491e481b9444e66b9a0168ea2990dc2363c5568533f50ac345b59a9e5ffa6f961966918b353ed6bfb0957ad38cbaf0adc6a94e873dbc81f2b6e43b36a5ab6bb86643f7d4de85d1bb7d8c8deba28");
    /**
     * The jump polynomial (2<sup>64</sup> steps).
     */
    public static final JumpPolynomial JUMP_EXP2_64 = new JumpPolynomial("f3bcce5b2e1526b39ab407f15242e54fd2372c5f941cf675c113803ee2ed7429203933b5255cf3c242f5f087444456594bf8f547f7b658d7ab6af1711650c8677adf6735e81ae7dfe4429900c2b1094");
    /**
     * The jump polynomial (2<sup>128</sup> steps).
     */
    public static final JumpPolynomial JUMP_EXP2_128 = new JumpPolynomial("2054eb3e5dc8a350da861cdabdb101c4d8d27fdd8dbc5e8674bc75063541b0eb04d784d7cd1003c31a67068f3ff7e09264ff8d6d311ef6cf1a60fc1ce2a0f41866d5a6e4ed305097d800e2eee26f89e5");
    /**
     * The jump polynomial (2<sup>256</sup> steps).
     */
    public static final JumpPolynomial JUMP_EXP2_256 = new JumpPolynomial("9718dcead9f70081c0445c4ef4ca09b54e93cb6ad9adafd9b182ccc8b9440a17b27b987f35a4f2ad696194e2930e0898acd810b76621fcce71278775dd2f03474af59aed68dd6535717ec5d0795f17c3");
    private static final int MEXP = 607;
    private static final int N = MEXP / 128 + 1;
    private static final int N32 = N * 4;
    private static final int POS1 = 2;
    private static final int SL1 = 15;
    private static final int SL2 = 3;
    private static final int SR1 = 13;
    private static final int SR2 = 3;
    private static final int MSK1 = 0xfdff37ff;
    private static final int MSK2 = 0xef7f3f7d;
    private static final int MSK3 = 0xff777b7d;
    private static final int MSK4 = 0x7ff7fb2f;
    private static final int PARITY1 = 0x00000001;
    private static final int PARITY2 = 0x00000000;
    private static final int PARITY3 = 0x00000000;
    private static final int PARITY4 = 0x5986f054;
    private static final int[] parity = {PARITY1, PARITY2, PARITY3, PARITY4};
    private int[] psfmt32 = new int[N32];
    private int idx;
    
    /**
     * Creates a new generator.
     * <br>
     * This constructor sets the generator's initial state using the current time.
     */
    public SFMT607() {
        int u = AtomicCounter.next();
        long nanos = System.nanoTime();
        init_by_array(u, (int)(nanos ^ (nanos >>> 32)));
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     */
    public SFMT607(int seed) {
        init_gen_rand(seed);
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     * @throws NullPointerException if {@code seed == null}
     */
    public SFMT607(int... seed) {
        init_by_array(seed);
    }
    
    SFMT607(SFMT607 r) {
        System.arraycopy(r.psfmt32, 0, psfmt32, 0, N32);
        idx = r.idx;
    }
    
    private void init_gen_rand(int seed) {
        psfmt32[0] = seed;
        for (int i = 1; i < N32; i++) {
            psfmt32[i] = 1812433253 * (psfmt32[i - 1] ^ (psfmt32[i - 1] >>> 30)) + i;
        }
        idx = N32;
        period_certification();
    }
    
    private void init_by_array(int... init_key) {
        final int lag = 3;
        final int mid = 8;
        Arrays.fill(psfmt32, 0x8b8b8b8b);
        int count;
        if (init_key.length + 1 > N32) {
            count = init_key.length + 1;
        }
        else {
            count = N32;
        }
        int r = func1(psfmt32[0] ^ psfmt32[mid] ^ psfmt32[N32 - 1]);
        psfmt32[mid] += r;
        r += init_key.length;
        psfmt32[mid + lag] += r;
        psfmt32[0] = r;
        count--;
        int i, j;
        for (i = 1, j = 0; (j < count) && (j < init_key.length); j++) {
            r = func1(psfmt32[i] ^ psfmt32[(i + mid) % N32] ^ psfmt32[(i + N32 - 1) % N32]);
            psfmt32[(i + mid) % N32] += r;
            r += init_key[j] + i;
            psfmt32[(i + mid + lag) % N32] += r;
            psfmt32[i] = r;
            i = (i + 1) % N32;
        }
        for (; j < count; j++) {
            r = func1(psfmt32[i] ^ psfmt32[(i + mid) % N32] ^ psfmt32[(i + N32 - 1) % N32]);
            psfmt32[(i + mid) % N32] += r;
            r += i;
            psfmt32[(i + mid + lag) % N32] += r;
            psfmt32[i] = r;
            i = (i + 1) % N32;
        }
        for (j = 0; j < N32; j++) {
            r = func2(psfmt32[i] + psfmt32[(i + mid) % N32] + psfmt32[(i + N32 - 1) % N32]);
            psfmt32[(i + mid) % N32] ^= r;
            r -= i;
            psfmt32[(i + mid + lag) % N32] ^= r;
            psfmt32[i] = r;
            i = (i + 1) % N32;
        }
        idx = N32;
        period_certification();
    }
    
    private void period_certification() {
        int inner = 0;
        for (int i = 0; i < 4; i++) {
            inner ^= psfmt32[i] & parity[i];
        }
        for (int i = 16; i > 0; i >>= 1) {
            inner ^= inner >> i;
        }
        inner &= 1;
        if (inner == 1) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int work = 1;
            for (int j = 0; j < 32; j++) {
                if ((work & parity[i]) != 0) {
                    psfmt32[i] ^= work;
                    return;
                }
                work = work << 1;
            }
        }
    }
    
    private static int func1(int x) {
        return (x ^ (x >>> 27)) * 1664525;
    }
    
    private static int func2(int x) {
        return (x ^ (x >>> 27)) * 1566083941;
    }
    
    @Override
    public int nextBits() {
        if (idx >= N32) {
            gen_rand_all();
            idx = 0;
        }
        return psfmt32[idx++];
    }
    
    private void gen_rand_all() {
        int r1 = (N - 2) * 4;
        int r2 = (N - 1) * 4;
        int i;
        for (i = 0; i < N - POS1; i++) {
            do_recursion(i * 4, i * 4, (i + POS1) * 4, r1, r2);
            r1 = r2;
            r2 = i * 4;
        }
        for (; i < N; i++) {
            do_recursion(i * 4, i * 4, (i + POS1 - N) * 4, r1, r2);
            r1 = r2;
            r2 = i * 4;
        }
    }
    
    private void do_recursion(int r, int a, int b, int c, int d) {
        int x0 = psfmt32[a] << (SL2 * 8);
        int x1 = (psfmt32[a + 1] << (SL2 * 8)) | (psfmt32[a] >>> (32 - SL2 * 8));
        int x2 = (psfmt32[a + 2] << (SL2 * 8)) | (psfmt32[a + 1] >>> (32 - SL2 * 8));
        int x3 = (psfmt32[a + 3] << (SL2 * 8)) | (psfmt32[a + 2] >>> (32 - SL2 * 8));
        int y0 = (psfmt32[c + 1] << (32 - SR2 * 8)) | (psfmt32[c] >>> (SR2 * 8));
        int y1 = (psfmt32[c + 2] << (32 - SR2 * 8)) | (psfmt32[c + 1] >>> (SR2 * 8));
        int y2 = (psfmt32[c + 3] << (32 - SR2 * 8)) | (psfmt32[c + 2] >>> (SR2 * 8));
        int y3 = psfmt32[c + 3] >>> (SR2 * 8);
        psfmt32[r] = psfmt32[a] ^ x0 ^ ((psfmt32[b] >>> SR1) & MSK1) ^ y0 ^ (psfmt32[d] << SL1);
        psfmt32[r + 1] = psfmt32[a + 1] ^ x1 ^ ((psfmt32[b + 1] >>> SR1) & MSK2) ^ y1 ^ (psfmt32[d + 1] << SL1);
        psfmt32[r + 2] = psfmt32[a + 2] ^ x2 ^ ((psfmt32[b + 2] >>> SR1) & MSK3) ^ y2 ^ (psfmt32[d + 2] << SL1);
        psfmt32[r + 3] = psfmt32[a + 3] ^ x3 ^ ((psfmt32[b + 3] >>> SR1) & MSK4) ^ y3 ^ (psfmt32[d + 3] << SL1);
    }
    
    /**
     * Advances this generator's state with a small amount of calculation.
     * @throws NullPointerException if {@code jumpPoly == null}
     */
    @Override
    public void jump(JumpPolynomial jumpPoly) {
        int[] work = new int[N32];
        int index = idx;
        idx = N32;
        for (int i = 0; i < jumpPoly.degree(); i++) {
            int bits = jumpPoly.coefficientAt(i);
            for (int j = 0; j < 4; j++) {
                if ((bits & 1) != 0) {
                    add(work, 0, psfmt32, idx);
                }
                next_state();
                bits = bits >> 1;
            }
        }
        psfmt32 = work;
        idx = index;
    }
    
    private static void add(int[] dest, int dest_idx, int[] src, int src_idx) {
        int dp = dest_idx / 4;
        int sp = src_idx / 4;
        int diff = (sp - dp + N) % N;
        int i;
        for (i = 0; i < N - diff; i++) {
            int p = i + diff;
            for (int j = 0; j < 4; j++) {
                dest[i * 4 + j] ^= src[p * 4 + j];
            }
        }
        for (; i < N; i++) {
            int p = i + diff - N;
            for (int j = 0; j < 4; j++) {
                dest[i * 4 + j] ^= src[p * 4 + j];
            }
        }
    }
    
    private void next_state() {
        int i = (idx / 4) % N;
        int r1 = ((i + N - 2) % N) * 4;
        int r2 = ((i + N - 1) % N) * 4;
        do_recursion(i * 4, i * 4, ((i + POS1) % N) * 4, r1, r2);
        r1 = r2;
        r2 = i * 4;
        idx = idx + 4;
    }
    
    /**
     * Returns a new jumped generator.
     * @throws NullPointerException if {@code jumpPoly == null}
     */
    @Override
    public SFMT607 copyAndJump(JumpPolynomial jumpPoly) {
        SFMT607 r = new SFMT607(this);
        r.jump(jumpPoly);
        return r;
    }
    
    void readyLongBits() {
        idx += idx & 0x1;
    }
    
}
