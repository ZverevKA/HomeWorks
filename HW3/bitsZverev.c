int addOK(int x, int y)
{
	int x1, y1, z, z1, a;
	x1 = ((x >> 31) & 1);
	y1 = ((y >> 31) & 1);
	z = x + y;
	z1 = ((z >> 31) & 1); // we have overflow if x and y have same sign, but x and z have different sign
	a = ((x1 ^ y1) | !(x1 ^ z1)); // z = 0 <=> (x1 = y1) and (x1 != z1)
	return a;
} 	 


int bang(int x)
{
	int y, x1, y1, a, b;
	y = ~x + 1; // y = -x
	x1 = (x >> 31) & 1;
	y1 = (y >> 31) & 1; // bit#32(x) = bit#32(-x) only if x = 0 or x = minint
	a = x1 | y1; // a = 0 <=> x = 0; else a = 1
	b = a ^ 1; // swap 1 and 0
	return b;
}


int bitAnd(int x, int y)
{
	int z;
	z = (~x | ~y); // (bit №i of z) == 0 if (bit №i of x and bit №i of y == 1);
	return ~z;
}


int bitXor(int x, int y)
{
	int z,t;
	z = ~(~x & ~y); // bit №i of z == 0 <=> bit №i of x and y == 0
	t = ~(x & y); // bit №i of t == 0 <=> bit №i of x and y == 1
	return (z & t); // bit №i ==0 <=> (bit №i of x) == (bit №i of y)
}


int conditional(int x, int y, int z)
{
	int a, b, c; 
	a = ~(!!(x ^ 0)) + 1; // if x != 0 then a = (11111..11)2, else a = 0
	b = ~(!(x^0)) + 1; // if x != 0 then a = 0, else a = (1111..11)2
	c = (a & y) + (b & z); // one of bracets equals 0, another equals y or z(that we need)
	return c;
}


int fitsBits(int x, int n)
{
	int a, b, c, d, e, n1;  // we need return 1 if -(2^(n-1)) <= x <= 2^(n-1) -1
	d = ~0; // d = -1
	n1 = n + d; // n1 = n - 1
	a = !(d & (x >> n1));  // is 0 <= x <= 2^(n-1) (else we have (bit#i = 1 ), i > (n-1)) ?
	b = (~(x + d))+d; // if x < 0 b = (|x| - 1) else (bit#32 = 1)
	e = !(d & (b >> n1)); // same "a"
	c = !(n ^ 32); // c = 1 if n = 32
	return (a | c | e);
}


int getByte(int x, int n)
{
	int y,z;
	z = n + n; // z=2n
	z = z + z; // z=4n
	z = z + z; // z=8n
	y = x >> z;
	return (y & 255);
}


int isPower(int x)
{
	int y;
	y = !(((~x + 1) & x) ^ x); // is x like 000...0001000..00
	z = !(!(0 ^ x)); // is x != 0 ?
	t = !((x >> 31) & 1); // is x >= 0 ?
	return (y & z & t);


}


int logicalShift(int x, int n)
{
	int a, b, c, d, n1;
	a = ((x >> 31) & 1); // a = 1 if x >= 0, else a = 0
	n1 = ~n + 1; // n1 = -n
	b = a << (32 + n1); 
	c = (x >> n) + b; // if bit#(32-n..32) were equal 1, after + b they will be 0
	return c;
}


int sign(int x)
{
	int a, b, d;
	d = ~0; // d = -1
	a = ((x >> 31) & d); // if x < 0 then a = -1, else a = 0
	b = ((~(x + d) >> 31) & 1); // b = 1 if (x > 0 or x = minint), else b = 0   
	return (a | b); // 1)x < 0: (a | anithing) equal -1, 2)x = 0: (0 | 0) equal 0, 3)x > 0: (0 | 1) equal 1
} 


int thirdBits()
{
	int x = 0, y = 146; // 146 = (10010010)2
	y = y << 1; // 100100100
	x += y;
	x = x << 9;
	x += y;
	x = x << 9;
	x += y;
	x = x << 3;
	x += 4; // 4 = (100)2
	return x;
}


