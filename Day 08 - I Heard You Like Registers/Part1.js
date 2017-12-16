function distinct(value, index, self) {  return self.indexOf(value) === index; }

var input = document.querySelector("body > pre").textContent.trim();

var allVariables = input.match(/[a-z]+/g).filter(x => x != "if").filter(distinct);
for (var variable of allVariables) { 
	eval("var "+variable+"=0;");
}

var lines = input.replace(/inc/g, "+=").replace(/dec/g, "-=").split("\n");
for (var line of lines) { 
	eval(line.replace(/([a-z]+? (?:\+|-)= -?\d+) if ([^$]+)/g, "if($2) {$1;}"));
}

var maximum = -9999;
for (var variable of allVariables) {  
	eval("if (" + variable + " > maximum) { maximum = " + variable + "; } ");
}

alert("Maximum = " + maximum);