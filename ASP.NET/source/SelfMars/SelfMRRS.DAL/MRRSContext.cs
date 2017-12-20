using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Data.Entity;

using SelfMRRS.Entity;

namespace SelfMRRS.DAL
{
    class MRRSContext:DbContext
    {
        public DbSet<Location> Locations { get; set; } 
        public DbSet<MeetingRoom> MeetingRooms { get; set; }
        public DbSet<Reservation> Reservations { get; set; }



    }
}
