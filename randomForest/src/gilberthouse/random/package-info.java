/**
 * RNGs implemented in Java.
 * <dl>
 * <dt>
 * Includes code from:
 * </dt>
 * <dd>
 * <pre>
 * <b>Mersenne Twister with improved initialization</b>
 * Copyright (C) 1997 - 2002, Makoto Matsumoto and Takuji Nishimura,
 * All rights reserved.
 * http://www.math.sci.hiroshima-u.ac.jp/~m-mat/MT/MT2002/emt19937ar.html
 * 
 * <b>Mersenne Twister 64bit version</b>
 * Copyright (C) 2004, Makoto Matsumoto and Takuji Nishimura,
 * All rights reserved.
 * http://www.math.sci.hiroshima-u.ac.jp/~m-mat/MT/emt64.html
 * 
 * <b>SIMD-oriented Fast Mersenne Twister (SFMT)</b>
 * Copyright (c) 2006,2007 Mutsuo Saito, Makoto Matsumoto and Hiroshima
 * University.
 * Copyright (c) 2012 Mutsuo Saito, Makoto Matsumoto, Hiroshima University
 * and The University of Tokyo.
 * All rights reserved.
 * http://www.math.sci.hiroshima-u.ac.jp/~m-mat/MT/SFMT/index.html
 * 
 * <b>SFMT Jump</b>
 * Copyright (c) 2006,2007 Mutsuo Saito, Makoto Matsumoto and Hiroshima
 * University.
 * Copyright (c) 2012 Mutsuo Saito, Makoto Matsumoto, Hiroshima University
 * and The University of Tokyo.
 * All rights reserved.
 * http://www.math.sci.hiroshima-u.ac.jp/~m-mat/MT/SFMT/JUMP/index.html
 * 
 * <b>WELL Random number generator</b>
 * Copyright:
 * Francois Panneton and Pierre L'Ecuyer, University of Montreal
 * Makoto Matsumoto, Hiroshima University
 * http://www.iro.umontreal.ca/~panneton/WELLRNG.html
 * 
 * <b>Xorshift RNGs</b>
 * George Marsaglia, The Florida State University
 * See http://en.wikipedia.org/wiki/Xorshift
 * </pre>
 * </dd>
 * <dt>
 * License:
 * </dt>
 * <dd>
 * <pre>
 * Copyright (c) 2014, GILBERT HOUSE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in
 *     the documentation and/or other materials provided with the
 *     distribution.
 * 
 *  3. The name of the author may not be used to
 *     endorse or promote products derived from this software without
 *     specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * </pre>
 * </dd>
 * </dl>
 */
package gilberthouse.random;
