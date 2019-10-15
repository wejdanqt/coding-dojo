//Q1
var myString: string;
// I can assign myString like this:
myString = "Bee stinger";
// Why is there a problem with this? What can I do to fix this?
//myString is declerd as a string so you can't assign it with number so you can change the 9 to string
myString = "9";

//Q2
function sayHello(name: string){
    return `Hello, ${name}!`;
 }
 // This is working great:
 console.log(sayHello("Kermit"));
 // Why isn't this working? I want it to return "Hello, 9!"
 // sayHello(name: string) you have to change the string to number or send 9 as string
 console.log(sayHello("9"));

 //Q3
 function fullName(firstName: string, lastName: string, middleName?: string){

    let fullName = `${firstName} ${middleName} ${lastName}`;
    return fullName;
 }
 // This works:
 console.log(fullName("Mary", "Moore", "Tyler"));
 // What do I do if someone doesn't have a middle name?
 // You can make the middle name as optional by adding '?'
 console.log(fullName("Jimbo", "Jones"));

 //Q4
 interface Student {
    firstName: string;
    lastName: string;
    belts: number;
 }
 function graduate(ninja: Student){
    return `Congratulations, ${ninja.firstName} ${ninja.lastName}, you earned ${ninja.belts} belts!`;
 }
 const christine = {
    firstName: "Christine",
    lastName: "Yang",
    belts: 2
 }
 const jay = {
    firstName: "Jay",
    lastName: "Patel",
    belts: 4 // missing s as belts in the interface 
 }
 // This seems to work fine:
 console.log(graduate(christine));
 // This one has problems:
 console.log(graduate(jay));
 
//Q5
class Ninja {
    fullName: string;
    constructor(
       public firstName: string,
       public lastName: string){
          this.fullName = `${firstName} ${lastName}`;
       }
    debug(){
       console.log("Console.log() is my friend.")
    }
 }
 // This is not making an instance of Ninja, for some reason:
 //Add new and the two required parameter in the constructor
 const shane = new Ninja('shane' , 'h');
 
 //Make an instance of turing
 const turing = new Ninja('Alan' , 'Turing');
 
 // Now I'll make a study function, which is a lot like our graduate function from above:
 function study(programmer: Ninja){
    return `Ready to whiteboard an algorithm, ${programmer.fullName}?`
 }
 // Now this has problems:
 console.log(study(turing));
 
 //6
 var increment = x => x + 1;
console.log(increment(3));
// remove braces
var square = x => x * x ;
console.log(square(4));
// add () to the parameters 
var multiply = (x,y) => x * y;
// add {} and make it as finction
var math = (x, y) => {
    let sum = x + y;
    let product = x * y;
    let difference = Math.abs(x - y);
    return [sum, product, difference];
};
//7
class Elephant {
    constructor(public age: number) { }
   //Fix it by use an arrow function
   birthday = () =>{
      this.age++;
   }
}
const babar = new Elephant(8);
setTimeout(babar.birthday, 1000)
setTimeout(function(){
   console.log(`Babar's age is ${babar.age}.`)
   }, 2000)




