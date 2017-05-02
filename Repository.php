<?php

  class Repository{

     var $repo;

     var $firstNameKey = 'firstname';
     var $lastNameKey = 'lastname';
     var $idKey       = 'id';
     var $imageKey    = 'image';

     
     function createRepository(){


         $s1 = Array($this->firstNameKey => 'Moti', $this->lastNameKey => 'Bartov', $this->idKey => '031992654', $this->imageKey => 'moti.jpg');
         $s2 = Array($this->firstNameKey => 'Donald', $this->lastNameKey => 'Trump', $this->idKey => '555', $this->imageKey => 'trump.jpg');
         
         $this->repo = Array($s1, $s2);
     }

     function getStudents(){
     	return $this->repo;
     }

     function getStudent($id){
     	return $this->repo[$id];
     }

  }

?>