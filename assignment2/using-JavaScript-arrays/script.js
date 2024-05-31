
// i used filter() method , and this method will display the index based on the condition
//this function is to delete from the middle of the array index.
function deleteFromMiddle(array) {
    const length = array.length;
    
    // If the array length is even -> delete the two from middle 
    if (length % 2 === 0) {
      const middleIndex = length / 2;
      return array.filter((_, index) => index !== middleIndex - 1 && index !== middleIndex); //condition
    } else {
      // If the array length is odd -> delete the middle 
      const middleIndex = Math.floor(length / 2);
      return array.filter((_, index) => index !== middleIndex); //condition
    }
  }


//i used reduce() method , it cobines the values and display one result
//this function is to count how many"true" words in the array.
  function countTrue(array) {
    return array.reduce((count, element) => count + (element === true), 0);
  }


  //i used entries() method convert object to an array 
  function toArray(object) {
    return Object.entries(object);
  }

// i used find() method to search for number 7
//toString to convert the array into string
//include() to check if the array include 7
  function luckyNumber(numbers) {
    const foundNumber = numbers.find(function(element) {
      return element.toString().includes('7');
    });
  
    if (foundNumber !== undefined) {
      return "LUCKY!";
    } else {
      return "there is no 7 in the array.";
    }
  }

//i used .reduce() array method to combine the values to produce a single result
  function oddishOrEvenish(num) {
    const sum = String(num)
      .split('') //to separate the string into an array of individual digits
      .reduce((acc, digit) => acc + Number(digit), 0); // to combine the digits
  
    if (sum % 2 === 0) {
      return 'Evenish';
    } else {
      return 'Oddish';
    }
  }
  

//i used map() because there is a transformation of a word
 function reverseOdd(str) {
  return str
    .split(' ') // to split the word into an array of digits
    .map(word => word.length % 2 === 1 ? word.split('').reverse().join('') : word)
    .join(' '); //rejoin it to a string
}


//sort() the words
function getHashTags(headline) {
  // Remove punctuation and convert headline to an array of words
  const words = headline.replace(/[^\w\s]/g, '').split(' ');

  // Sort the words by length from longer to shorter
  const sortedWords = words.sort((a, b) => b.length - a.length);

  // get the first 3 words that alredy sorted by the longest
  const top3Words = sortedWords.slice(0, 3);

  // Transform the words into hashtags
  const hashtags = top3Words.map(word => `#${word.toLowerCase()}`);

  return hashtags;
}
  

  
  //delete from the middle
  const array1 = ["A", "B", "Middle", "D", "E"];
  console.log(deleteFromMiddle(array1)); // Output: ["A", "B", "D", "E"]
  
  const array2 = ["A", "B", "Middle", "Middle", "D", "E"];
  console.log(deleteFromMiddle(array2)); // Output: [1, 2, 4, 5, 6]

  //true counter
  const array = [true, false, false, true, false];
  console.log(countTrue(array)); 

  //key-value pair in the form of an array.
  const object1= { a: 1, b: 2 };
  console.log(toArray(object1)); 

  //Lucky! search for number 7
  const numbers1 = [1, 2, 3, 4, 5, 6, 7];
  console.log(luckyNumber(numbers1));
  const numbers2 = [8, 6, 33, 100];
  console.log(luckyNumber(numbers2));
  const numbers3 = [2, 55, 60, 97, 86];
  console.log(luckyNumber(numbers3));

  //odd OR evenish number
  console.log(oddishOrEvenish(121)); 
  console.log(oddishOrEvenish(41)); 

  //reverse if the word's length is odd

console.log(reverseOdd("Bananas"));
console.log(reverseOdd("One two three four"));
console.log(reverseOdd("Make sure uoy only esrever sdrow of ddo length")); 


//get the biggest 3 words and convert it into hashtags
console.log(getHashTags("How the Avocado Became the Fruit of the Global Trade"));
console.log(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
console.log(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
console.log(getHashTags("Visualizing Science"));
