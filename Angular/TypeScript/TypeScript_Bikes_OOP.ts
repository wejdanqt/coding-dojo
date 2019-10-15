class Bike{
    miles: number;
    price: number;
    max_speed: string;
    constructor(price: number, max_speed: string) {
        this.miles = 0;
        this.price = price;
        this.max_speed = max_speed;
    }
    displayInfo() {
        console.log(this.price, this.max_speed ,this.miles)
         
     }
    ride() {
        console.log("Riding")
        this.miles += 10
        return this
    }
    reverse() {
        console.log("Reversing")
        if (this.miles > 5) {
            this.miles -= 5
            
        }
        else {
            console.log("can't be reversied")
        }
      

    }
}

const bike1 = new Bike(7, "20mph")
bike1.ride()
bike1.ride()
bike1.ride()
bike1.reverse()
bike1.displayInfo()

const bike2 = new Bike(4, "15mph")
bike2.ride()
bike2.ride()
bike2.reverse()
bike2.reverse()
bike2.displayInfo()

const bike3 = new Bike(9, "16mph")
bike3.reverse()
bike3.reverse()
bike3.reverse()
bike3.displayInfo()
