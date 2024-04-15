export interface Orders {

    id : number,
    parts : {
        id: number,
        name :  string,
        description : string
    },

    suppliers : {
        id: number,
        name : string,
        address :  string,
        phoneNumber : number
    },
     quantity: number,
     orderDate : Date

}
