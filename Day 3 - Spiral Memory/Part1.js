function range (start, end) { return [...Array(1+end-start).keys()].map(v => start+v); }
function offCenter (array, value) { return Math.floor(array.length / 2) - ( array.indexOf(value) != -1 ? array.indexOf(value) : "." ); } // terrible error handling by provoking NaN, yay!

function steps (input) {
	var brcSqrt = Math.ceil(Math.sqrt(input));
	brcSqrt += brcSqrt % 2 == 0 ? 1 : 0;

	var brc = brcSqrt * brcSqrt;
	var blc = brc - brcSqrt + 1;
	var tlc = blc - brcSqrt + 1;
	var trc = tlc - brcSqrt + 1;
	var min = trc - brcSqrt + 1;

	// Here stops the fancy maths 

	var x = offCenter( range(blc, brc), input );
	if(isNaN(x)) { x = offCenter( range(trc, tlc), input ) * - 1; }
	if(isNaN(x)) { x = Math.floor(brcSqrt / 2); }

	var y = offCenter( range(tlc, blc), input ) * - 1;
	if(isNaN(y)) { y = offCenter( range(min, trc), input ); }
	if(isNaN(y)) { y = Math.floor(brcSqrt / 2); }

	return Math.abs(x) + Math.abs(y);
}