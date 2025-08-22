
import { add } from './calc2.js'

const result = add(10,10);
console.log(`더하기 결과 : ${result}`);

import * as calc from './calc2.js'

const result2 = calc.add(10,10);
console.log(`더하기 결과 : ${result2}`);