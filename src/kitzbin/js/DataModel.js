var DataModel = {

       Initialize: function(private){
         //private.name = name;
         //private.salary = salary;
       },
       Private:{
           collapse_time: 300,
           slide_toggle_time: 200
           
       },
       Public:{
           getCollapseTime: function(private){
               return private.collapse_time;
           },
           getSlideToggleTime: function(private){
               return private.slide_toggle_time;
           },
           raiseSalary: function(private, byPercent){
               var raise = private.salary * byPercent / 100;
               private.salary += raise;
           }
       }

   };