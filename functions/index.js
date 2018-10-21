exports.updateUser = functions.firestore
    .document('Laundry/{Floor1}')
    .onUpdate((change, context) => {
      // Get an object representing the document
      // e.g. {'name': 'Marie', 'age': 66}
      const newValue = change.after.data();

      // ...or the previous value before this update
      const previousValue = change.before.data();

      // access a particular field as you would any JS property
      const name = newValue.name;
      
      if(previousValue > 0){
        name = previousValue - 1;
      }
      return name;
      // perform desired operations ...
    });
