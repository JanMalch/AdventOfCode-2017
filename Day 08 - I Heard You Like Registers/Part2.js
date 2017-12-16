function distinct(value, index, self) {  return self.indexOf(value) === index; }

function checkAllTimeMax() { 
	for(var variable of allVariables) {  
		eval("if (" + variable + " > allTimeMax ) { allTimeMax = " + variable + "; } ");
	}
}

var allTimeMax = -9999;
var input = document.querySelector("body > pre").textContent.trim();

var allVariables = input.match(/[a-z]+/g).filter(x => x != "if").filter(distinct);
for(var variable of allVariables) {
	eval("var "+variable+"=0;");
}

var lines = input.replace(/inc/g, "+=").replace(/dec/g, "-=").split("\n");
for(var line of lines) {
	eval(line.replace(/([a-z]+? (?:\+|-)= -?\d+) if ([^$]+)/g, "if($2) {$1;}"));
	checkAllTimeMax();
}

alert("All Time Maximum = " + allTimeMax);